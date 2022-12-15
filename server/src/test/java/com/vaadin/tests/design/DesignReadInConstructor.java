/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.design;

import com.vaadin.ui.CssLayout;
import com.vaadin.ui.declarative.Design;

public class DesignReadInConstructor extends CssLayout {

    public DesignReadInConstructor() {
        Design.read(
                getClass().getResourceAsStream("DesignReadInConstructor.html"),
                this);
    }
}
