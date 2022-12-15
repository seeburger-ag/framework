/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.push;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.vaadin.testbench.parallel.TestCategory;
import com.vaadin.tests.tb3.MultiBrowserTest;

@TestCategory("push")
public class EnableDisablePushTest extends MultiBrowserTest {
    @Test
    public void testEnablePushWhenUsingPolling() throws Exception {
        openTestURL();

        assertEquals("1. Push enabled", getLogRow(0));

        getDisablePushButton().click();
        assertEquals("3. Push disabled", getLogRow(0));

        getEnablePollButton().click();
        assertEquals("5. Poll enabled", getLogRow(0));

        getEnablePushButton().click();
        assertEquals("7. Push enabled", getLogRow(0));

        getDisablePollButton().click();
        assertEquals("9. Poll disabled", getLogRow(0));

        getDisablePushButtonAndReenableFromBackground().click();
        Thread.sleep(2500);
        assertEquals("16. Polling disabled, push enabled", getLogRow(0));

        getDisablePushButton().click();
        assertEquals("18. Push disabled", getLogRow(0));
    }

    private WebElement getDisablePushButton() {
        return vaadinElement(
                "/VVerticalLayout[0]/Slot[1]/VVerticalLayout[0]/Slot[0]/VButton[0]");
    }

    private WebElement getEnablePushButton() {
        return vaadinElement(
                "/VVerticalLayout[0]/Slot[1]/VVerticalLayout[0]/Slot[1]/VButton[0]");
    }

    private WebElement getDisablePollButton() {
        return vaadinElement(
                "/VVerticalLayout[0]/Slot[1]/VVerticalLayout[0]/Slot[2]/VButton[0]");
    }

    private WebElement getEnablePollButton() {
        return vaadinElement(
                "/VVerticalLayout[0]/Slot[1]/VVerticalLayout[0]/Slot[3]/VButton[0]");
    }

    private WebElement getDisablePushButtonAndReenableFromBackground() {
        return vaadinElement(
                "/VVerticalLayout[0]/Slot[1]/VVerticalLayout[0]/Slot[4]/VButton[0]");
    }

}
