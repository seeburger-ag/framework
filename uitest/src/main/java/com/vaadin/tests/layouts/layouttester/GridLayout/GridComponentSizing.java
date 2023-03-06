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

/**
 *
 * @since
 * @author Vaadin Ltd
 */
public class GridComponentSizing extends GridBaseLayoutTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        getLayoutForLayoutSizing("component");
        super.setup(request);
        layout.setSizeFull();
    }
}
