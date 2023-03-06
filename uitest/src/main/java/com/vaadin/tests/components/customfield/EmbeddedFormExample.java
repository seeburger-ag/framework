/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.customfield;

public class EmbeddedFormExample extends AbstractNestedFormExample {

    @Override
    protected void setup() {
        super.setup(true);
    }

    @Override
    protected String getDescription() {
        return "An address form embedded in a person form.\n"
                + "The address fields are placed in the layout of the parent (person) form.\n"
                + "Note that in many cases the same result can be achieved with a property that maps subfields to the top level.";
    }

}
