/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.ui;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.testbench.elements.LabelElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

public class UIsInMultipleTabsTest extends MultiBrowserTest {

    @Test
    public void testPageReloadChangesUI() throws Exception {
        openTestURL();
        assertUI(1);
        openTestURL();
        assertUI(2);
        openTestURL("restartApplication");
        assertUI(1);
    }

    private void assertUI(int i) {
        Assert.assertEquals("Unexpected UI found,", "This is UI number " + i,
                $(LabelElement.class).first().getText());
    }
}
