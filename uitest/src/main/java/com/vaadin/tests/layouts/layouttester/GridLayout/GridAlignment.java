/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.layouts.layouttester.GridLayout;

import com.vaadin.server.VaadinRequest;

public class GridAlignment extends GridBaseLayoutTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        buildLayout();
        super.setup(request);
        layout.setSizeFull();
    }

    /**
     * Build Layout for test
     */
    private void buildLayout() {
        layout.setColumns(3);
        layout.setRows(3);
        for (int i = 0; i < components.length; i++) {
            layout.addComponent(components[i]);
            layout.setComponentAlignment(components[i], alignments[i]);
        }
    }
}
