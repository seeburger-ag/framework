/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.widgetset.client;

import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.client.ui.VLabel;
import com.vaadin.shared.ui.Connect;
import com.vaadin.tests.widgetset.server.MissingFromDefaultWidgetsetComponent;

@Connect(MissingFromDefaultWidgetsetComponent.class)
public class MissingFromDefaultWidgetsetConnector
        extends AbstractComponentConnector {
    @Override
    public VLabel getWidget() {
        return (VLabel) super.getWidget();
    }

    @Override
    protected void init() {
        getWidget().setText(
                "This component is available in TestingWidgetset, but not in DefaultWidgetset");
        super.init();
    }
}
