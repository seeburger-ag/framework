/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.widgetset.server;

import com.vaadin.tests.widgetset.client.UseStateFromHierachyChangeConnectorState;
import com.vaadin.ui.AbstractSingleComponentContainer;
import com.vaadin.ui.Component;

public class UseStateFromHierachyComponent
        extends AbstractSingleComponentContainer {

    @Override
    protected UseStateFromHierachyChangeConnectorState getState() {
        return (UseStateFromHierachyChangeConnectorState) super.getState();
    }

    @Override
    public void setContent(Component content) {
        getState().child = content;
        super.setContent(content);
    }

}
