/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.server.communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResource.TRANSPORT;
import org.atmosphere.cpr.BroadcastFilterAdapter;
import org.atmosphere.util.Version;

import com.vaadin.shared.communication.PushConstants;
import com.vaadin.ui.UI;

/**
 * A {@link PushConnection} implementation using the Atmosphere push support
 * that is by default included in Vaadin.
 *
 * @author Vaadin Ltd
 * @since 7.1
 */
public class AtmospherePushConnection implements PushConnection {

    public static String getAtmosphereVersion() {
        try {
            String v = Version.getRawVersion();
            assert v != null;
            return v;
        } catch (NoClassDefFoundError e) {
            return null;
        }
    }

    /**
     * Represents a message that can arrive as multiple fragments.
     */
    protected static class FragmentedMessage implements Serializable {
        private final StringBuilder message = new StringBuilder();
        private final int messageLength;

        public FragmentedMessage(Reader reader) throws IOException {
            // Messages are prefixed by the total message length plus a
            // delimiter
            String length = "";
            int c;
            while ((c = reader.read()) != -1
                    && c != PushConstants.MESSAGE_DELIMITER) {
                length += (char) c;
            }
            try {
                messageLength = Integer.parseInt(length);
            } catch (NumberFormatException e) {
                throw new IOException("Invalid message length " + length, e);
            }
        }

        /**
         * Appends all the data from the given Reader to this message and
         * returns whether the message was completed.
         *
         * @param reader
         *            The Reader from which to read.
         * @return true if this message is complete, false otherwise.
         * @throws IOException
         */
        public boolean append(Reader reader) throws IOException {
            char[] buffer = new char[PushConstants.WEBSOCKET_BUFFER_SIZE];
            int read;
            while ((read = reader.read(buffer)) != -1) {
                message.append(buffer, 0, read);
                assert message.length() <= messageLength : "Received message "
                        + message.length() + "chars, expected " + messageLength;
            }
            return message.length() == messageLength;
        }

        public Reader getReader() {
            return new StringReader(message.toString());
        }
    }

    protected enum State {
        /**
         * Not connected. Trying to push will set the connection state to
         * PUSH_PENDING or RESPONSE_PENDING and defer sending the message until
         * a connection is established.
         */
        DISCONNECTED,

        /**
         * Not connected. An asynchronous push is pending the opening of the
         * connection.
         */
        PUSH_PENDING,

        /**
         * Not connected. A response to a client request is pending the opening
         * of the connection.
         */
        RESPONSE_PENDING,

        /**
         * Connected. Messages can be sent through the connection.
         */
        CONNECTED;
    }

    private UI ui;
    private transient State state = State.DISCONNECTED;
    private transient AtmosphereResource resource;
    private transient FragmentedMessage incomingMessage;
    private transient Future<Object> outgoingMessage;

    private transient Object lock = new Object();

    public AtmospherePushConnection(UI ui) {
        this.ui = ui;
    }

    @Override
    public void push() {
        push(true);
    }

    /**
     * Pushes pending state changes and client RPC calls to the client. If
     * {@code isConnected()} is false, defers the push until a connection is
     * established.
     *
     * @param async
     *            True if this push asynchronously originates from the server,
     *            false if it is a response to a client request.
     */
    public void push(boolean async) {
        synchronized (lock) {
            if (!isConnected()) {
                if (async && state != State.RESPONSE_PENDING) {
                    state = State.PUSH_PENDING;
                } else {
                    state = State.RESPONSE_PENDING;
                }
            } else {
                try {
                    Writer writer = new StringWriter();
                    new UidlWriter().write(getUI(), writer, async);
                    sendMessage("for(;;);[{" + writer.toString() + "}]");
                } catch (Exception e) {
                    throw new RuntimeException("Push failed", e);
                }
            }
        }
    }

    /**
     * Sends the given message to the current client. Cannot be called if
     * {@isConnected()} is false.
     *
     * @param message
     *            The message to send
     */
    void sendMessage(String message) {
        assert (isConnected());
        // "Broadcast" the changes to the single client only
        outgoingMessage = getResource().getBroadcaster()
                .broadcast(new PushMessage(
                        ui.getConnectorTracker().getCurrentSyncId() - 1,
                        message), getResource());
    }

    /**
     * Reads and buffers a (possibly partial) message. If a complete message was
     * received, or if the call resulted in the completion of a partially
     * received message, returns a {@link Reader} yielding the complete message.
     * Otherwise, returns null.
     *
     * @param reader
     *            A Reader from which to read the (partial) message
     * @return A Reader yielding a complete message or null if the message is
     *         not yet complete.
     * @throws IOException
     */
    protected Reader receiveMessage(Reader reader) throws IOException {

        if (resource == null || resource.transport() != TRANSPORT.WEBSOCKET) {
            return reader;
        }

        if (incomingMessage == null) {
            // No existing partially received message
            incomingMessage = new FragmentedMessage(reader);
        }

        if (incomingMessage.append(reader)) {
            // Message is complete
            Reader completeReader = incomingMessage.getReader();
            incomingMessage = null;
            return completeReader;
        } else {
            // Only received a partial message
            return null;
        }
    }

    @Override
    public boolean isConnected() {
        assert state != null;
        assert (state == State.CONNECTED) ^ (resource == null);
        return state == State.CONNECTED;
    }

    /**
     * Associates this {@link AtmospherePushConnection} with the given
     * {@link AtmosphereResource} representing an established push connection.
     * If already connected, calls {@link #disconnect()} first. If there is a
     * deferred push, carries it out via the new connection.
     *
     * @since 7.2
     */
    public void connect(AtmosphereResource resource) {

        assert resource != null;
        assert resource != this.resource;

        if (isConnected()) {
            disconnect();
        }

        this.resource = resource;
        State oldState = state;
        state = State.CONNECTED;

        if (oldState == State.PUSH_PENDING
                || oldState == State.RESPONSE_PENDING) {
            // Sending a "response" message (async=false) also takes care of a
            // pending push, but not vice versa
            push(oldState == State.PUSH_PENDING);
        }
    }

    /**
     * Gets the UI this push connection is associated with.
     *
     * @return the UI associated with this connection
     */
    public UI getUI() {
        return ui;
    }

    /**
     * Gets the atmosphere resource associated with this connection.
     *
     * @return The AtmosphereResource associated with this connection or
     *         <code>null</code> if the connection is not open.
     */
    public AtmosphereResource getResource() {
        return resource;
    }

    @Override
    public void disconnect() {
        synchronized (lock) {
            assert isConnected();

            if (resource == null) {
                // Already disconnected. Should not happen but if it does, we
                // don't
                // want to cause NPEs
                getLogger().fine(
                        "AtmospherePushConnection.disconnect() called twice, this should not happen");
                return;
            }
            if (resource.isResumed()) {
                // This can happen for long polling because of
                // http://dev.vaadin.com/ticket/16919
                // Once that is fixed, this should never happen
                connectionLost();
                return;
            }

            if (outgoingMessage != null) {
                // Wait for the last message to be sent before closing the
                // connection (assumes that futures are completed in order)
                try {
                    outgoingMessage.get(1000, TimeUnit.MILLISECONDS);
                } catch (TimeoutException e) {
                    getLogger().log(Level.INFO,
                            "Timeout waiting for messages to be sent to client before disconnect");
                } catch (Exception e) {
                    getLogger().log(Level.INFO,
                            "Error waiting for messages to be sent to client before disconnect");
                }
                outgoingMessage = null;
            }

            try {
                resource.close();
            } catch (IOException e) {
                getLogger().log(Level.INFO,
                        "Error when closing push connection", e);
            }
            connectionLost();
        }
    }

    /**
     * Called when the connection to the client has been lost.
     *
     * @since 7.4.1
     */
    public void connectionLost() {
        resource = null;
        if (state == State.CONNECTED) {
            // Guard against connectionLost being (incorrectly) called when
            // state is PUSH_PENDING or RESPONSE_PENDING
            // (http://dev.vaadin.com/ticket/16919)
            state = State.DISCONNECTED;
        }

    }

    /**
     * Returns the state of this connection.
     */
    protected State getState() {
        return state;
    }

    /**
     * Reinitializes this PushConnection after deserialization. The connection
     * is initially in disconnected state; the client will handle the
     * reconnecting.
     */
    private void readObject(ObjectInputStream stream)
            throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        state = State.DISCONNECTED;
        lock = new Object();
    }

    private static Logger getLogger() {
        return Logger.getLogger(AtmospherePushConnection.class.getName());
    }

    /**
     * Internal method used for reconfiguring loggers to show all Atmosphere log
     * messages in the console.
     *
     * @since 7.6
     */
    public static void enableAtmosphereDebugLogging() {
        Level level = Level.FINEST;

        Logger atmosphereLogger = Logger.getLogger("org.atmosphere");
        if (atmosphereLogger.getLevel() == level) {
            // Already enabled
            return;
        }

        atmosphereLogger.setLevel(level);

        // Without this logging, we will have a ClassCircularityError
        LogRecord record = new LogRecord(Level.INFO,
                "Enabling Atmosphere debug logging");
        atmosphereLogger.log(record);

        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.ALL);
        atmosphereLogger.addHandler(ch);
    }

    static final class PushMessage implements Serializable {
        final int serverSyncId;
        final String message;

        PushMessage(int serverSyncId, String message) {
            this.serverSyncId = serverSyncId;
            this.message = message;
        }

        boolean alreadySeen(int lastSeenOnClient) {
            return serverSyncId <= lastSeenOnClient;
        }
    }

    /**
     * A {@link org.atmosphere.cpr.BroadcastFilter} that unwraps the message to
     * be sent to the client from a {@link PushMessage} instance.
     */
    static final class PushMessageUnwrapFilter extends BroadcastFilterAdapter
            implements Serializable {
        @Override
        public BroadcastAction filter(String broadcasterId,
                AtmosphereResource r, Object originalMessage, Object message) {
            if (message instanceof AtmospherePushConnection.PushMessage) {
                message = ((PushMessage) message).message;
            }
            return new BroadcastAction(message);
        }
    }
}
