/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.layouts.layouttester.VLayout;

import java.util.Iterator;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.layouts.layouttester.BaseLayoutForSpacingMargin;
import com.vaadin.ui.AbstractOrderedLayout;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @since
 * @author Vaadin Ltd
 */

public class VLayoutMarginSpacing extends BaseLayoutForSpacingMargin {

    /**
     * @param layoutClass
     */
    public VLayoutMarginSpacing() {
        super(VerticalLayout.class);
    }

    @Override
    protected void setup(VaadinRequest request) {
        super.setup(request);
        Iterator<Component> iterator = l2.iterator();
        while (iterator.hasNext()) {
            Component component = iterator.next();
            if (component instanceof Table) {
                component.setSizeUndefined();
            } else if (component instanceof Label) {
                component.setWidth("100%");
            }
        }
    }

    @Override
    protected void setLayoutMeasures(AbstractOrderedLayout l1,
            AbstractOrderedLayout l2, String w, String h) {
        l1.setSizeUndefined();
        l2.setSizeUndefined();
    }

}
