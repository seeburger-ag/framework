/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.tabsheet;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.TabSheetElement;
import com.vaadin.tests.tb3.MultiBrowserTest;
import junit.framework.Assert;
import org.junit.Test;

public class FirstTabNotVisibleInTabsheetTest extends MultiBrowserTest {
    @Test
    public void testFirstTabIsVisibleAfterBeingInvisible() {
        openTestURL();

        toggleFirstTabVisibility();
        toggleFirstTabVisibility();

        TabSheetElement tabSheet = $(TabSheetElement.class).first();

        Assert.assertTrue("TabSheet should have first tab visible",
                tabSheet.getTabCaptions().contains("first visible tab"));
    }

    private void toggleFirstTabVisibility() {
        $(ButtonElement.class).caption("Toggle first tab").first().click();
    }
}
