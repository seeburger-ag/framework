/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.minitutorials.v7a2;

import com.vaadin.tests.widgetset.client.minitutorials.v7a2.ComponentInStateState;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Component;

public class ComponentInStateComponent extends AbstractComponent {

    @Override
    public ComponentInStateState getState() {
        return (ComponentInStateState) super.getState();
    }

    public void setOtherComponent(Component component) {
        getState().otherComponent = component;
    }

    public Component getOtherComponent() {
        return (Component) getState().otherComponent;
    }
}
