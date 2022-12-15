/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.server;

import java.util.EventObject;

import com.vaadin.ui.UI;

/**
 * Base class providing common functionality used in different bootstrap
 * modification events.
 *
 * @author Vaadin Ltd
 * @since 7.0.0
 */
public abstract class BootstrapResponse extends EventObject {
    private final VaadinRequest request;
    private final VaadinSession session;
    private final Class<? extends UI> uiClass;
    private final UIProvider uiProvider;

    /**
     * Creates a new bootstrap event.
     *
     * @param handler
     *            the bootstrap handler that is firing the event
     * @param request
     *            the Vaadin request for which the bootstrap page should be
     *            generated
     * @param session
     *            the session for which the bootstrap page should be generated
     * @param uiClass
     *            the class of the UI that will be displayed on the page
     * @param uiProvider
     *            the UI provider for the bootstrap
     */
    public BootstrapResponse(BootstrapHandler handler, VaadinRequest request,
            VaadinSession session, Class<? extends UI> uiClass,
            UIProvider uiProvider) {
        super(handler);
        this.request = request;
        this.session = session;
        this.uiClass = uiClass;
        this.uiProvider = uiProvider;
    }

    /**
     * Gets the bootstrap handler that fired this event
     *
     * @return the bootstrap handler that fired this event
     */
    public BootstrapHandler getBootstrapHandler() {
        return (BootstrapHandler) getSource();
    }

    /**
     * Gets the request for which the generated bootstrap HTML will be the
     * response. This can be used to read request headers and other additional
     * information. Please note that {@link VaadinRequest#getBrowserDetails()}
     * will not be available because the bootstrap page is generated before the
     * bootstrap javascript has had a chance to send any information back to the
     * server.
     *
     * @return the Vaadin request that is being handled
     */
    public VaadinRequest getRequest() {
        return request;
    }

    /**
     * Gets the service session to which the rendered view belongs.
     *
     * @return the Vaadin service session
     */
    public VaadinSession getSession() {
        return session;
    }

    /**
     * Gets the class of the UI that will be displayed on the generated
     * bootstrap page.
     *
     * @return the class of the UI
     */
    public Class<? extends UI> getUiClass() {
        return uiClass;
    }

    /**
     * Gets the UI provider that is used to provide information about the
     * bootstapped UI.
     *
     * @return the UI provider
     */
    public UIProvider getUIProvider() {
        return uiProvider;
    }

}
