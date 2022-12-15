/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.customfield;

public class NestedFormExample extends AbstractNestedFormExample {

    @Override
    protected void setup() {
        super.setup(false);
    }

    @Override
    protected String getDescription() {
        return "An address form nested in a person form.";
    }

}
