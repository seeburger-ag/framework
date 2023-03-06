/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.client;

import com.google.gwt.user.client.ui.FlowPanel;

public class VCaptionWrapper extends FlowPanel {

    public static final String CLASSNAME = "v-captionwrapper";
    VCaption caption;
    ComponentConnector wrappedConnector;

    /**
     * Creates a new caption wrapper panel.
     *
     * @param toBeWrapped
     *            paintable that the caption is associated with, not null
     * @param client
     *            ApplicationConnection
     */
    public VCaptionWrapper(ComponentConnector toBeWrapped,
            ApplicationConnection client) {
        caption = new VCaption(toBeWrapped, client);
        add(caption);
        wrappedConnector = toBeWrapped;
        add(wrappedConnector.getWidget());
        setStyleName(CLASSNAME);
    }

    public void updateCaption() {
        caption.updateCaption();
    }

    public ComponentConnector getWrappedConnector() {
        return wrappedConnector;
    }
}
