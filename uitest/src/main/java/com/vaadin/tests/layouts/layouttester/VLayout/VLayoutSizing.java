/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.layouts.layouttester.VLayout;

import com.vaadin.tests.layouts.layouttester.BaseLayoutSizing;
import com.vaadin.ui.AbstractOrderedLayout;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @since
 * @author Vaadin Ltd
 */

public class VLayoutSizing extends BaseLayoutSizing {

    /**
     * @param layoutClass
     */
    public VLayoutSizing() {
        super(VerticalLayout.class);
    }

    @Override
    protected void setLayoutMeasures(AbstractOrderedLayout l1,
            AbstractOrderedLayout l2, String w, String h) {
        l1.setWidth("400px");
        l1.setHeight("-1px");
        l2.setWidth("400px");
        l2.setHeight("500px");
    }
}
