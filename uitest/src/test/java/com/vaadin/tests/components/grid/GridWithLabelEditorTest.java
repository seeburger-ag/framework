/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.vaadin.testbench.elements.GridElement;
import com.vaadin.tests.tb3.SingleBrowserTest;

public class GridWithLabelEditorTest extends SingleBrowserTest {

    @Test
    public void testNoExceptionOnEdit() {
        setDebug(true);
        openTestURL();

        assertNoErrorNotifications();

        assertEquals("LabelEditor content not correct.", "FooFoo",
                $(GridElement.class).first().getEditor().getField(0).getText());
    }
}
