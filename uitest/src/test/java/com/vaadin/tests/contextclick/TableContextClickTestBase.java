/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.contextclick;

import static org.junit.Assert.assertEquals;

import com.vaadin.testbench.elements.TableElement;

public abstract class TableContextClickTestBase
        extends AbstractContextClickTest {

    @Override
    protected Class<?> getUIClass() {
        return TableContextClick.class;
    }

    protected void assertTypedContextClickListener(int startIndex) {
        contextClick($(TableElement.class).first().getCell(0, 0));

        assertEquals(
                (startIndex++)
                        + ". ContextClickEvent value: Lisa Schneider, propertyId: address, section: BODY",
                getLogRow(0));

        contextClick($(TableElement.class).first().getCell(0, 3));

        assertEquals(
                startIndex
                        + ". ContextClickEvent value: Lisa Schneider, propertyId: lastName, section: BODY",
                getLogRow(0));
    }
}
