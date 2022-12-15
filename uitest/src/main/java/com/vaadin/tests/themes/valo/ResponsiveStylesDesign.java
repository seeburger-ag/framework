/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.themes.valo;

import com.vaadin.annotations.DesignRoot;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.declarative.Design;

@DesignRoot
@SuppressWarnings("serial")
public class ResponsiveStylesDesign extends VerticalLayout {

    protected Component collapsed;
    protected Component narrow;
    protected Component wide;

    public ResponsiveStylesDesign() {
        Design.read(this);
    }
}
