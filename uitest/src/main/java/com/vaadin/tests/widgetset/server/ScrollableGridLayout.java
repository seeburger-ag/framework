/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.widgetset.server;

import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;

public class ScrollableGridLayout extends GridLayout {

    public ScrollableGridLayout() {
        super();
    }

    public ScrollableGridLayout(int columns, int rows, Component... children) {
        super(columns, rows, children);
    }

    public ScrollableGridLayout(int columns, int rows) {
        super(columns, rows);
    }
}
