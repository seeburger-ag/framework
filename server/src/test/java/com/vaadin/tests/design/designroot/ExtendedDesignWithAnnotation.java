/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.design.designroot;

import com.vaadin.ui.TextField;

public class ExtendedDesignWithAnnotation extends DesignWithAnnotation {
    private TextField customField = new TextField();

    public ExtendedDesignWithAnnotation() {
        customField.setInputPrompt("Something");
        addComponent(customField);

    }
}
