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
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.atmosphere.cpr.AtmosphereRequest;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceEvent;
import org.atmosphere.cpr.AtmosphereResourceEventListenerAdapter;
import org.atmosphere.handler.AbstractReflectorAtmosphereHandler;

/**
 * Handles Atmosphere requests and forwards them to logical methods in
 * {@link PushHandler}
 *
 * @since 7.5.0
 * @author Vaadin Ltd
 */
public class PushAtmosphereHandler extends AbstractReflectorAtmosphereHandler
        implements Serializable {

    private PushHandler pushHandler = null;

    public void setPushHandler(PushHandler pushHandler) {
        this.pushHandler = pushHandler;
    }

    private static final Logger getLogger() {
        return Logger.getLogger(PushAtmosphereHandler.class.getName());
    }

    @Override
    public void onStateChange(AtmosphereResourceEvent event)
            throws IOException {
        super.onStateChange(event);
        if (pushHandler == null) {
            getLogger().warning(
                    "AtmosphereHandler.onStateChange called before PushHandler has been set. This should really not happen");
            return;
        }

        if (event.isCancelled() || event.isResumedOnTimeout()) {
            pushHandler.connectionLost(event);
        }
    }

    @Override
    public void onRequest(AtmosphereResource resource) {
        if (pushHandler == null) {
            getLogger().warning(
                    "AtmosphereHandler.onRequest called before PushHandler has been set. This should really not happen");
            return;
        }

        AtmosphereRequest req = resource.getRequest();

        if (req.getMethod().equalsIgnoreCase("GET")) {
            onConnect(resource);
        } else if (req.getMethod().equalsIgnoreCase("POST")) {
            onMessage(resource);
        }
    }

    /**
     * Called when the client sends a message through the push channel
     *
     * @param resource
     */
    private void onMessage(AtmosphereResource resource) {
        pushHandler.onMessage(resource);
    }

    /**
     * Called when the client sends the first request (to establish a push
     * connection)
     *
     * @param resource
     */
    private void onConnect(AtmosphereResource resource) {
        resource.addEventListener(new AtmosphereResourceListener());

        pushHandler.onConnect(resource);
    }

    private class AtmosphereResourceListener extends
            AtmosphereResourceEventListenerAdapter implements Serializable {

        @Override
        public void onDisconnect(AtmosphereResourceEvent event) {
            // Log event on trace level
            super.onDisconnect(event);
            pushHandler.connectionLost(event);
        }

        @Override
        public void onThrowable(AtmosphereResourceEvent event) {
            getLogger().log(Level.SEVERE, "Exception in push connection",
                    event.throwable());
            pushHandler.connectionLost(event);
        }
    }
}
