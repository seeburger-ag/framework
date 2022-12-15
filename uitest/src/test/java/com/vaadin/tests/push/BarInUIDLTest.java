/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.push;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.vaadin.testbench.parallel.TestCategory;
import com.vaadin.tests.tb3.MultiBrowserTest;

@TestCategory("push")
public class BarInUIDLTest extends MultiBrowserTest {
    @Test
    public void sendBarInUIDL() {
        openTestURL();
        getButton().click();
        Assert.assertEquals("Thank you for clicking | bar",
                vaadinElement(
                        "/VVerticalLayout[0]/Slot[1]/VVerticalLayout[0]/Slot[1]/VLabel[0]")
                                .getText());
        getButton().click();
        Assert.assertEquals("Thank you for clicking | bar",
                vaadinElement(
                        "/VVerticalLayout[0]/Slot[1]/VVerticalLayout[0]/Slot[2]/VLabel[0]")
                                .getText());
    }

    private WebElement getButton() {
        return vaadinElement(
                "/VVerticalLayout[0]/Slot[1]/VVerticalLayout[0]/Slot[0]/VButton[0]");
    }
}
