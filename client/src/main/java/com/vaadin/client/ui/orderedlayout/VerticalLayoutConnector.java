/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.orderedlayout;

import com.vaadin.client.ui.VVerticalLayout;
import com.vaadin.shared.ui.Connect;
import com.vaadin.shared.ui.Connect.LoadStyle;
import com.vaadin.shared.ui.orderedlayout.VerticalLayoutState;
import com.vaadin.ui.VerticalLayout;

/**
 * Connects the client widget {@link VVerticalLayout} with the Vaadin server
 * side counterpart {@link VerticalLayout}
 */
@Connect(value = VerticalLayout.class, loadStyle = LoadStyle.EAGER)
public class VerticalLayoutConnector extends AbstractOrderedLayoutConnector {

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.client.ui.orderedlayout.AbstractOrderedLayoutConnector#
     * getWidget ()
     */
    @Override
    public VVerticalLayout getWidget() {
        return (VVerticalLayout) super.getWidget();
    }

    @Override
    public VerticalLayoutState getState() {
        return (VerticalLayoutState) super.getState();
    }
}
