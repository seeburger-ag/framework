/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.components;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.AbstractComponent;

public class UnknownComponentConnector extends AbstractTestUI {

    public static class ComponentWithoutConnector extends AbstractComponent {

    }

    @Override
    protected void setup(VaadinRequest request) {
        ComponentWithoutConnector component = new ComponentWithoutConnector();
        component.setId("no-connector-component");
        addComponent(component);
    }

    @Override
    protected String getTestDescription() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Integer getTicketNumber() {
        // TODO Auto-generated method stub
        return null;
    }

}
