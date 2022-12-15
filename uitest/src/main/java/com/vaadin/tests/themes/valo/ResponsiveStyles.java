/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.themes.valo;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

@Theme("valo")
public class ResponsiveStyles extends UI {

    @Override
    protected void init(VaadinRequest request) {
        ResponsiveStylesDesign design = new ResponsiveStylesDesign();
        setContent(design);

        boolean collapsed = request.getParameter("collapsed") != null;

        design.collapsed.setVisible(collapsed);
        design.narrow.setVisible(!collapsed);
        design.wide.setVisible(!collapsed);
    }

}
