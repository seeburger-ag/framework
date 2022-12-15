/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.design.designroot;

import com.vaadin.annotations.DesignRoot;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.declarative.Design;

@DesignRoot
public class DesignWithEmptyAnnotation extends VerticalLayout {

    protected Button ok;
    protected Button CaNCEL;
    protected Label preInitializedField = new Label("original");

    public DesignWithEmptyAnnotation() {
        Design.read(this);
    }
}
