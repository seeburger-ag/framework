/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.widgetset.server;

import com.vaadin.tests.widgetset.client.GenericWidgetState;
import com.vaadin.ui.AbstractComponent;

public class GenericWidgetComponent extends AbstractComponent {

    @Override
    protected GenericWidgetState getState() {
        return (GenericWidgetState) super.getState();
    }

    public void setGenericText(String genericText) {
        getState().genericText = genericText;
    }
}
