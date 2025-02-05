/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid.basicfeatures;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.vaadin.testbench.parallel.TestCategory;
import com.vaadin.tests.tb3.MultiBrowserTest;

@TestCategory("grid")
public class GridClientDataSourcesTest extends MultiBrowserTest {

    @Before
    public void before() {
        openTestURL();
    }

    @Test
    public void normalRestishDatasource() throws Exception {
        selectMenuPath("DataSources", "RESTish", "Use");
        assertCellPresent("cell 0 #0");

        scrollToBottom();
        assertCellPresent("cell 199 #0");
        assertCellNotPresent("cell 200 #0");
    }

    @Test
    public void growOnRequestRestishDatasource() throws Exception {
        selectMenuPath("DataSources", "RESTish", "Use");
        selectMenuPath("DataSources", "RESTish", "Next request +10");

        scrollToBottom();
        /* second scroll needed because of scrollsize change after scrolling */
        scrollToBottom();

        assertCellPresent("cell 209 #1");
        assertCellNotPresent("cell 210 #1");
    }

    @Test
    public void shrinkOnRequestRestishDatasource() throws Exception {
        selectMenuPath("DataSources", "RESTish", "Use");
        scrollToBottom();

        selectMenuPath("DataSources", "RESTish", "Next request -10");
        scrollToTop();

        assertCellPresent("cell 0 #1");
    }

    @Test
    public void pushChangeRestishDatasource() throws Exception {
        selectMenuPath("DataSources", "RESTish", "Use");
        selectMenuPath("DataSources", "RESTish", "Push data change");
        assertCellPresent("cell 0 #1");
        assertCellNotPresent("cell 0 #0");
    }

    @Test
    public void growOnPushRestishDatasource() throws Exception {
        selectMenuPath("DataSources", "RESTish", "Use");
        selectMenuPath("DataSources", "RESTish", "Push data change +10");
        assertCellPresent("cell 0 #1");
        assertCellNotPresent("cell 0 #0");
        scrollToBottom();
        assertCellPresent("cell 209 #1");
    }

    @Test
    public void shrinkOnPushRestishDatasource() throws Exception {
        selectMenuPath("DataSources", "RESTish", "Use");
        scrollToBottom();

        selectMenuPath("DataSources", "RESTish", "Push data change -10");
        assertCellPresent("cell 189 #1");
        assertCellNotPresent("cell 189 #0");
        assertCellNotPresent("cell 199 #1");
        assertCellNotPresent("cell 199 #0");
    }

    private void assertCellPresent(String content) {
        try {
            waitForElementPresent(By.xpath("//td[text()='" + content + "']"));
        } catch (TimeoutException e) {
            fail("A cell with content \"" + content
                    + "\" should've been found");
        }
    }

    private void assertCellNotPresent(String content) {
        try {
            waitForElementNotPresent(
                    By.xpath("//td[text()='" + content + "']"));
        } catch (TimeoutException e) {
            fail("A cell with content \"" + content
                    + "\" should not have been found");
        }
    }

    private void scrollToTop() {
        scrollVerticallyTo(0);
    }

    private void scrollToBottom() {
        scrollVerticallyTo(9999);
    }

    private WebElement findByXPath(String string) {
        if (isElementPresent(By.xpath(string))) {
            return findElement(By.xpath(string));
        } else {
            return null;
        }
    }

    private void scrollVerticallyTo(int px) {
        executeScript("arguments[0].scrollTop = " + px,
                findVerticalScrollbar());
    }

    private Object executeScript(String script, Object args) {
        final WebDriver driver = getDriver();
        if (driver instanceof JavascriptExecutor) {
            final JavascriptExecutor je = (JavascriptExecutor) driver;
            return je.executeScript(script, args);
        } else {
            throw new IllegalStateException("current driver "
                    + getDriver().getClass().getName() + " is not a "
                    + JavascriptExecutor.class.getSimpleName());
        }
    }

    private WebElement findVerticalScrollbar() {
        return getDriver().findElement(By.xpath(
                "//div[contains(@class, " + "\"v-grid-scroller-vertical\")]"));
    }

    @Override
    protected void selectMenu(String menuCaption) {
        // GWT menu does not need to be clicked.
        selectMenu(menuCaption, false);
    }

    @Override
    protected WebElement getMenuElement(String menuCaption) {
        return getDriver()
                .findElement(By.xpath("//td[text() = '" + menuCaption + "']"));
    }

}
