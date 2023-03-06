/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.widgetset.server;

import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.tests.widgetset.TestingWidgetSet;
import com.vaadin.tests.widgetset.client.WidgetUtilTestComponentState;
import com.vaadin.ui.AbstractComponent;

@Widgetset(TestingWidgetSet.NAME)
public class WidgetUtilUI extends AbstractTestUI {

    public static class WidgetUtilTestComponent extends AbstractComponent {

        public WidgetUtilTestComponent(boolean inline) {
            getState().inline = inline;
        }

        @Override
        protected WidgetUtilTestComponentState getState() {
            return (WidgetUtilTestComponentState) super.getState();
        }
    }

    @Override
    protected void setup(VaadinRequest request) {
        addComponent(new WidgetUtilTestComponent(
                request.getParameter("inline") != null));
    }
}
