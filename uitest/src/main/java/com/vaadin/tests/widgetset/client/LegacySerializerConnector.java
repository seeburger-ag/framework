/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.widgetset.client;

import com.google.gwt.user.client.ui.HTML;
import com.vaadin.client.ApplicationConnection;
import com.vaadin.client.Paintable;
import com.vaadin.client.UIDL;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;
import com.vaadin.tests.serialization.LegacySerializerUI.LegacySerializerComponent;

@Connect(value = LegacySerializerComponent.class)
public class LegacySerializerConnector extends AbstractComponentConnector
        implements Paintable {

    @Override
    public void updateFromUIDL(UIDL uidl, ApplicationConnection client) {
        double doubleAttribute = uidl.getDoubleAttribute("doubleInfinity");
        getWidget().setHTML("doubleInfinity: " + doubleAttribute);
        client.updateVariable(getConnectorId(), "doubleInfinity",
                doubleAttribute, true);
    }

    @Override
    public HTML getWidget() {
        return (HTML) super.getWidget();
    }
}
