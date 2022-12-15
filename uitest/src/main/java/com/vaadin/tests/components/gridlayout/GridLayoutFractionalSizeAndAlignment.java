/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.gridlayout;

import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUIWithLog;
import com.vaadin.tests.widgetset.TestingWidgetSet;
import com.vaadin.tests.widgetset.server.ScrollableGridLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;

@Widgetset(TestingWidgetSet.NAME)
public class GridLayoutFractionalSizeAndAlignment
        extends AbstractTestUIWithLog {

    @Override
    protected void setup(VaadinRequest request) {
        widthTest();
        heightTest();
    }

    private void widthTest() {
        final GridLayout layout = new ScrollableGridLayout(1, 1);
        layout.setMargin(false);
        layout.setSpacing(true);

        layout.setWidth(525.04f, Unit.PIXELS);

        Button button = new Button("Button");

        layout.addComponent(button);
        layout.setComponentAlignment(button, Alignment.BOTTOM_RIGHT);

        addComponent(layout);
    }

    private void heightTest() {
        final GridLayout layout = new ScrollableGridLayout(1, 1);
        layout.setMargin(false);
        layout.setSpacing(true);

        layout.setWidth(525.04f, Unit.PIXELS);
        layout.setHeight(525.04f, Unit.PIXELS);

        Button button = new Button("Button");

        layout.addComponent(button);
        layout.setComponentAlignment(button, Alignment.BOTTOM_RIGHT);

        addComponent(layout);
    }
}
