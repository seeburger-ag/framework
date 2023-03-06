/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.tabsheet;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.testbench.elements.LabelElement;
import com.vaadin.testbench.elements.TabSheetElement;
import com.vaadin.tests.tb3.SingleBrowserTest;

public class VetoTabChangeTest extends SingleBrowserTest {
    @Test
    public void testReselectTabAfterVeto() {
        openTestURL();

        TabSheetElement tabSheet = $(TabSheetElement.class).first();
        Assert.assertEquals("Tab 1 should be there by default", "Tab 1",
                getTabContent(tabSheet));

        tabSheet.openTab(1);

        Assert.assertEquals("Tab should not have changed", "Tab 1",
                getTabContent(tabSheet));

        tabSheet.openTab(0);
        Assert.assertEquals("Tab should still be there", "Tab 1",
                getTabContent(tabSheet));
    }

    private String getTabContent(TabSheetElement tabSheet) {
        return tabSheet.getContent(LabelElement.class).getText();
    }
}
