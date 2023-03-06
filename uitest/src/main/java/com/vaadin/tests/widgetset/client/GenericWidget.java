/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.widgetset.client;

import com.google.gwt.user.client.ui.Label;

public class GenericWidget<T> extends Label {
    public void setGenericText(T value) {
        setText(String.valueOf(value));
    }
}
