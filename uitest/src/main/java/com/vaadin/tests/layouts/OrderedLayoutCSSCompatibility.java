/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.layouts;

import com.vaadin.tests.components.TestBase;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;

public class OrderedLayoutCSSCompatibility extends TestBase {

    @Override
    protected String getDescription() {
        return "This test is to make sure that spacing/margins in OrderedLayout is still backwards compatible";
    }

    @Override
    protected Integer getTicketNumber() {
        return 2463;
    }

    @Override
    protected void setup() {
        HorizontalLayout l = new HorizontalLayout();
        l.setMargin(true);
        l.setSpacing(true);
        l.addComponent(new TextField("abc"));
        l.addComponent(new TextField("def"));

        addComponent(l);

    }

}
