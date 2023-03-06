/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.window;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUIWithLog;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Window;

public class GridInWindow extends AbstractTestUIWithLog {

    @Override
    protected void setup(VaadinRequest request) {
        final Grid grid = new Grid();

        grid.addColumn("Hidable column").setHidable(true);
        grid.addRow("Close and reopen and it vanishes");

        Button popupButton = new Button("Open PopUp",
                new Button.ClickListener() {
                    @Override
                    public void buttonClick(Button.ClickEvent event) {
                        Window subWindow = new Window("Sub-window");
                        subWindow.setContent(grid);
                        subWindow.setWidth(600, Unit.PIXELS);
                        subWindow.setWidth(400, Unit.PIXELS);
                        getUI().addWindow(subWindow);
                    }
                });

        addComponent(popupButton);

    }

}
