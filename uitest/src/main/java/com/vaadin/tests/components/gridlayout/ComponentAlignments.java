/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.gridlayout;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.VerticalLayout;

/**
 * Test UI for TOP_CENTER and TOP_RIGHT alignments in VerticalLayout.
 *
 * @author Vaadin Ltd
 */
public class ComponentAlignments extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {

        CheckBox topcenter = new CheckBox("Top Center");
        topcenter.setSizeUndefined();
        VerticalLayout verticalLayout1 = new VerticalLayout(topcenter);
        verticalLayout1.setHeight("40px");
        verticalLayout1.setWidth("140px");
        verticalLayout1.setComponentAlignment(topcenter, Alignment.TOP_CENTER);
        addComponent(verticalLayout1);

        CheckBox topright = new CheckBox("Top Right");
        topright.setSizeUndefined();
        VerticalLayout verticalLayout2 = new VerticalLayout(topright);
        verticalLayout2.setHeight("40px");
        verticalLayout2.setWidth("140px");
        verticalLayout2.setComponentAlignment(topright, Alignment.TOP_RIGHT);
        addComponent(verticalLayout2);

    }

    @Override
    protected Integer getTicketNumber() {
        return 14137;
    }

    @Override
    public String getDescription() {
        return "TOP_CENTER and TOP_RIGHT alignments should work in VerticalLayout";
    }

}
