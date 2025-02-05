/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.panel;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.testbench.By;
import com.vaadin.tests.tb3.MultiBrowserTest;

public class PanelChangeContentsTest extends MultiBrowserTest {

    @Test
    public void testReattachComponentUsingPush() {
        setPush(true);
        openTestURL();

        Assert.assertEquals("stats",
                vaadinElement(
                        "/VVerticalLayout[0]/Slot[1]/VPanel[0]/VVerticalLayout[0]/Slot[0]/VLabel[0]")
                                .getText());
        vaadinElement(
                "/VVerticalLayout[0]/Slot[0]/VHorizontalLayout[0]/Slot[1]/VButton[0]/domChild[0]/domChild[0]")
                        .click();
        Assert.assertEquals("companies",
                vaadinElement(
                        "/VVerticalLayout[0]/Slot[1]/VPanel[0]/VVerticalLayout[0]/Slot[0]/VLabel[0]")
                                .getText());
        vaadinElement(
                "/VVerticalLayout[0]/Slot[0]/VHorizontalLayout[0]/Slot[0]/VButton[0]/domChild[0]/domChild[0]")
                        .click();
        Assert.assertEquals("stats",
                vaadinElement(
                        "/VVerticalLayout[0]/Slot[1]/VPanel[0]/VVerticalLayout[0]/Slot[0]/VLabel[0]")
                                .getText());

        assertElementNotPresent(By.className("caption-with-html"));
    }
}
