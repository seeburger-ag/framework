/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.layouts;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUIWithLog;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

public class HorizontalLayoutWithLabelAndButton extends AbstractTestUIWithLog {

    @Override
    protected void setup(VaadinRequest request) {
        HorizontalLayout hl = new HorizontalLayout();
        hl.setSpacing(true);
        hl.setWidth("100%");
        Label l = new Label();
        l.setCaption("POTUS Database");
        l.setSizeUndefined();

        Button b = new Button("Add new");
        hl.addComponents(l, b);
        b.setStyleName("primary");
        hl.setExpandRatio(b, 1);

        addComponent(hl);
    }

}
