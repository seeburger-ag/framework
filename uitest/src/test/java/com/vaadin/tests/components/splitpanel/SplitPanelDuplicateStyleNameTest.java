/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.splitpanel;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;

import com.vaadin.shared.ui.splitpanel.HorizontalSplitPanelState;
import com.vaadin.testbench.elements.HorizontalSplitPanelElement;
import com.vaadin.testbench.elements.VerticalSplitPanelElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

/**
 * Test for duplicate primary style name in SplitPanel.
 *
 * @author Vaadin Ltd
 */
public class SplitPanelDuplicateStyleNameTest extends MultiBrowserTest {

    @Override
    public void setup() throws Exception {
        super.setup();
        openTestURL();
        waitForElementPresent(By.className("v-splitpanel-horizontal"));
    }

    @Test
    public void testHorizontalNoDuplicateStyleName() {
        HorizontalSplitPanelElement split = $(HorizontalSplitPanelElement.class)
                .first();
        String classNames = split.getAttribute("class");
        String primaryStyleName = new HorizontalSplitPanelState().primaryStyleName;
        assertEquals("Duplicate primary style name should not exist",
                classNames.indexOf(primaryStyleName),
                classNames.lastIndexOf(primaryStyleName));
    }

    @Test
    public void testVerticalNoDuplicateStyleName() {
        VerticalSplitPanelElement split = $(VerticalSplitPanelElement.class)
                .first();
        String classNames = split.getAttribute("class");
        String primaryStyleName = new HorizontalSplitPanelState().primaryStyleName;
        assertEquals("Duplicate primary style name should not exist",
                classNames.indexOf(primaryStyleName),
                classNames.lastIndexOf(primaryStyleName));
    }
}
