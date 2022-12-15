/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.design.nested.customlayouts;

import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;

/**
 * @author Vaadin Ltd
 */
public class CustomFormLayout extends FormLayout {
    public CustomFormLayout() {
        this.addComponent(new Label());
    }
}
