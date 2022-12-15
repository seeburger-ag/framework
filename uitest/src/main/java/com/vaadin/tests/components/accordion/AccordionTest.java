/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.accordion;

import com.vaadin.tests.components.tabsheet.TabSheetTest;
import com.vaadin.ui.Accordion;

public class AccordionTest extends TabSheetTest<Accordion> {

    @Override
    protected Class<Accordion> getTestClass() {
        return Accordion.class;
    }
}
