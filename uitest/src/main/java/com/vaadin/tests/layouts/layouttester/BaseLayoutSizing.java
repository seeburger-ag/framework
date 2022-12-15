/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.layouts.layouttester;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.AbstractLayout;

/**
 *
 * @since
 * @author Vaadin Ltd
 */
public class BaseLayoutSizing extends BaseLayoutTestUI {
    /**
     * @param layoutClass
     */
    public BaseLayoutSizing(Class<? extends AbstractLayout> layoutClass) {
        super(layoutClass);
    }

    @Override
    protected void setup(VaadinRequest request) {
        init();
        getLayoutForLayoutSizing("layout");
        super.setup(request);
    }
}
