/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.orderedlayout;

import com.vaadin.client.ui.VHorizontalLayout;
import com.vaadin.shared.ui.Connect;
import com.vaadin.shared.ui.Connect.LoadStyle;
import com.vaadin.shared.ui.orderedlayout.HorizontalLayoutState;
import com.vaadin.ui.HorizontalLayout;

/**
 * Connects the client widget {@link VHorizontalLayout} with the Vaadin server
 * side counterpart {@link HorizontalLayout}
 */
@Connect(value = HorizontalLayout.class, loadStyle = LoadStyle.EAGER)
public class HorizontalLayoutConnector extends AbstractOrderedLayoutConnector {

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.client.ui.orderedlayout.AbstractOrderedLayoutConnector#
     * getWidget ()
     */
    @Override
    public VHorizontalLayout getWidget() {
        return (VHorizontalLayout) super.getWidget();
    }

    @Override
    public HorizontalLayoutState getState() {
        return (HorizontalLayoutState) super.getState();
    }

}
