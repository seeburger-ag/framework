/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.extensions;

import com.vaadin.annotations.Theme;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;

@Theme("tests-responsive")
public class ResponsiveLayoutUpdate extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        HorizontalLayout layout = new HorizontalLayout();
        layout.addStyleName("layout-update");
        layout.setWidth("100%");
        setContent(layout);
        Responsive.makeResponsive(layout);

        Label label = new Label(
                "This label changes its size between the breakpoints, allowing more space for the adjacent component.");
        label.addStyleName("change-width");
        label.setSizeUndefined();
        layout.addComponent(label);

        Panel panel = new Panel("Panel");
        panel.setContent(new Label(
                "This Panel should be maximized in both breakpoints."));
        panel.setSizeFull();
        layout.addComponent(panel);
        layout.setExpandRatio(panel, 1);
    }

    @Override
    protected String getTestDescription() {
        return "A new layout phase should be requested after a new breakpoint is triggered, ensuring any style changes affecting component sizes are taken into account.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 14354;
    }
}
