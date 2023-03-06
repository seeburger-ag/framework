/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui;

import com.vaadin.shared.ui.AbstractLayoutState;

public abstract class AbstractLayoutConnector
        extends AbstractComponentContainerConnector {

    @Override
    public AbstractLayoutState getState() {
        return (AbstractLayoutState) super.getState();
    }
}
