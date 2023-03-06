/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.server.communication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.Broadcaster;
import org.easymock.EasyMock;
import org.junit.Test;
import org.mockito.Mockito;

import com.vaadin.server.ClientConnector;
import com.vaadin.server.LegacyCommunicationManager;
import com.vaadin.server.MockVaadinSession;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.communication.AtmospherePushConnection.State;
import com.vaadin.ui.ConnectorTracker;
import com.vaadin.ui.UI;

@SuppressWarnings("deprecation")
public class AtmospherePushConnectionTest {
    @Test
    public void testSerialization() throws Exception {

        UI ui = EasyMock.createNiceMock(UI.class);
        AtmosphereResource resource = EasyMock
                .createNiceMock(AtmosphereResource.class);

        AtmospherePushConnection connection = new AtmospherePushConnection(ui);
        connection.connect(resource);

        assertEquals(State.CONNECTED, connection.getState());

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        new ObjectOutputStream(baos).writeObject(connection);

        connection = (AtmospherePushConnection) new ObjectInputStream(
                new ByteArrayInputStream(baos.toByteArray())).readObject();

        assertEquals(State.DISCONNECTED, connection.getState());
    }

    @Test
    public void pushWhileDisconnect_disconnectedWithoutSendingMessage()
            throws Exception {

        UI ui = Mockito.spy(new UI() {
            @Override
            protected void init(VaadinRequest request) {
                // NOP
            }
        });
        ConnectorTracker tracker = Mockito.mock(ConnectorTracker.class);
        Mockito.when(ui.getConnectorTracker()).thenReturn(tracker);
        Mockito.when(tracker.getDirtyVisibleConnectors())
                .thenReturn(new ArrayList<ClientConnector>());

        final MockVaadinSession vaadinSession = new MockVaadinSession();
        Mockito.when(ui.getSession()).thenReturn(vaadinSession);
        Broadcaster broadcaster = Mockito.mock(Broadcaster.class);
        AtmosphereResource resource = Mockito.mock(AtmosphereResource.class);
        Mockito.when(resource.getBroadcaster()).thenReturn(broadcaster);

        final AtmospherePushConnection connection = new AtmospherePushConnection(
                ui);
        connection.connect(resource);

        final CountDownLatch latch = new CountDownLatch(1);
        CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                vaadinSession.lock();
                try {
                    connection.push();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                } finally {
                    vaadinSession.unlock();
                    latch.countDown();
                }
            }
        });
        connection.disconnect();
        assertTrue("AtmospherePushConnection not disconnected",
                latch.await(2, TimeUnit.SECONDS));
        assertEquals(State.PUSH_PENDING, connection.getState());
        Mockito.verifyZeroInteractions(broadcaster);
    }

    @Test
    public void disconnectWhilePush_messageSentAndThenDisconnected()
            throws Exception {

        UI ui = Mockito.spy(new UI() {
            @Override
            protected void init(VaadinRequest request) {
                // NOP
            }
        });
        ConnectorTracker tracker = Mockito.mock(ConnectorTracker.class);
        Mockito.when(ui.getConnectorTracker()).thenReturn(tracker);
        Mockito.when(tracker.getDirtyVisibleConnectors())
                .thenReturn(new ArrayList<ClientConnector>());

        final MockVaadinSession vaadinSession = new MockVaadinSession();
        Mockito.when(ui.getSession()).thenReturn(vaadinSession);
        Broadcaster broadcaster = Mockito.mock(Broadcaster.class);
        AtmosphereResource resource = Mockito.mock(AtmosphereResource.class);
        Mockito.when(resource.getBroadcaster()).thenReturn(broadcaster);

        final AtmospherePushConnection connection = new AtmospherePushConnection(
                ui);
        connection.connect(resource);

        final CountDownLatch latch = new CountDownLatch(1);
        CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                vaadinSession.lock();
                try {
                    vaadinSession.setCommunicationManager(
                            new LegacyCommunicationManager(vaadinSession));
                    CompletableFuture.runAsync(new Runnable() {
                        @Override
                        public void run() {
                            connection.disconnect();
                        }
                    });
                    connection.push();
                } catch (Throwable ex) {
                    throw new RuntimeException(ex);
                } finally {
                    vaadinSession.unlock();
                    latch.countDown();
                }
            }
        });
        assertTrue("Push not completed", latch.await(2, TimeUnit.SECONDS));
        Mockito.verify(broadcaster).broadcast(any(Object.class), eq(resource));
    }
}
