/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.dd;

import com.vaadin.client.ApplicationConnection;
import com.vaadin.client.Paintable;
import com.vaadin.client.UIDL;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;
import com.vaadin.tests.dd.CustomDDImplementation.MyDropTarget;

@Connect(MyDropTarget.class)
public class MyDropTargetConnector extends AbstractComponentConnector
        implements Paintable {

    @Override
    public void updateFromUIDL(UIDL uidl, ApplicationConnection client) {
        if (!isRealUpdate(uidl)) {
            return;
        }
        getWidget().client = client;
    }

    @Override
    public VMyDropTarget getWidget() {
        return (VMyDropTarget) super.getWidget();
    }

}
