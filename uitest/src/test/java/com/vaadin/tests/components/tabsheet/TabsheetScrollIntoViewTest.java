/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.tabsheet;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.TabSheetElement;
import com.vaadin.testbench.parallel.Browser;
import com.vaadin.tests.tb3.MultiBrowserTest;

public class TabsheetScrollIntoViewTest extends MultiBrowserTest {

    @Override
    public List<DesiredCapabilities> getBrowsersToTest() {
        List<DesiredCapabilities> browsers = super.getBrowsersToTest();
        // For whatever reason, IE8 never returns from the
        // $(TabSheetElement.class).first() call
        browsers.remove(Browser.IE8.getDesiredCapabilities());
        return browsers;
    }

    @Test
    public void scrollIntoView() {
        openTestURL();

        $(ButtonElement.class).id(TabsheetScrollIntoView.BTN_SELECT_LAST_TAB)
                .click();
        TabSheetElement tabSheet = $(TabSheetElement.class).first();
        Assert.assertTrue("Select last should not hide other tabs",
                tabSheet.getTabCaptions().contains("Tab 98"));

        List<WebElement> scrollerPrev = tabSheet
                .findElements(By.className("v-tabsheet-scrollerPrev"));
        Assert.assertTrue("Select last should not disable tab scrolling",
                !scrollerPrev.isEmpty() && scrollerPrev.get(0).isDisplayed());
    }

}
