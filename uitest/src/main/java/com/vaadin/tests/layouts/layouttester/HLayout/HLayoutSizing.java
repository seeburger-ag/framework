/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.layouts.layouttester.HLayout;

import java.util.Iterator;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.layouts.layouttester.BaseLayoutSizing;
import com.vaadin.ui.AbstractOrderedLayout;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @since
 * @author Vaadin Ltd
 */

public class HLayoutSizing extends BaseLayoutSizing {

    /**
     * @param layoutClass
     */
    public HLayoutSizing() {
        super(HorizontalLayout.class);
    }

    @Override
    protected void setup(VaadinRequest request) {
        super.setup(request);
        Iterator<Component> iterator = l2.iterator();
        while (iterator.hasNext()) {
            Component component = iterator.next();
            if (component instanceof Label) {
                component.setWidth("30px");
            }
        }
        mainLayout.setSizeFull();
        getLayout().setSizeFull();
        if (getLayout().getParent() instanceof VerticalLayout) {
            ((VerticalLayout) getLayout().getParent()).setSizeFull();
        }
        mainLayout.setExpandRatio(l2, 2);
    }

    @Override
    protected void setLayoutMeasures(AbstractOrderedLayout l1,
            AbstractOrderedLayout l2, String w, String h) {
        super.setLayoutMeasures(l1, l2, "900px", h);
        l1.setSizeUndefined();
    }
}
