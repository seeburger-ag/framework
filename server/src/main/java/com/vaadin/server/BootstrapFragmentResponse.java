/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.server;

import java.util.List;

import org.jsoup.nodes.Node;

import com.vaadin.ui.UI;

/**
 * A representation of a bootstrap fragment being generated. The bootstrap
 * fragment is the HTML code that will make up the actual application. This also
 * includes the JavaScript that initializes the application.
 *
 * @author Vaadin Ltd
 * @since 7.0.0
 */
public class BootstrapFragmentResponse extends BootstrapResponse {
    private final List<Node> fragmentNodes;

    /**
     * Crate a new bootstrap fragment response.
     *
     * @see BootstrapResponse#BootstrapResponse(BootstrapHandler, VaadinRequest,
     *      VaadinSession, Class)
     *
     * @param handler
     *            the bootstrap handler that is firing the event
     * @param request
     *            the Vaadin request for which the bootstrap page should be
     *            generated
     * @param session
     *            the service session for which the bootstrap page should be
     *            generated
     * @param uiClass
     *            the class of the UI that will be displayed on the page
     * @param fragmentNodes
     *            a mutable list containing the DOM nodes that will make up the
     *            application HTML
     * @param uiProvider
     *            the UI provider for the bootstrap
     */
    public BootstrapFragmentResponse(BootstrapHandler handler,
            VaadinRequest request, VaadinSession session,
            Class<? extends UI> uiClass, List<Node> fragmentNodes,
            UIProvider uiProvider) {
        super(handler, request, session, uiClass, uiProvider);
        this.fragmentNodes = fragmentNodes;
    }

    /**
     * Gets the list of DOM nodes that will be used to generate the fragment
     * HTML. Changes to the returned list will be reflected in the generated
     * HTML.
     *
     * @return the current list of DOM nodes that makes up the application
     *         fragment
     */
    public List<Node> getFragmentNodes() {
        return fragmentNodes;
    }

}
