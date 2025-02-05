/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.splitpanel;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import com.vaadin.testbench.elements.CheckBoxElement;
import com.vaadin.testbench.elements.TextFieldElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

public class GridLayoutWithCheckboxTest extends MultiBrowserTest {

    private TextFieldElement tf;
    private WebElement tfSlot;
    private CheckBoxElement cb;
    private WebElement cbSlot;
    private Dimension tfSize;
    private Dimension tfSlotSize;
    private Dimension cbSize;
    private Dimension cbSlotSize;

    @Test
    public void layoutShouldStayTheSame() {
        openTestURL();
        tf = $(TextFieldElement.class).first();
        tfSlot = tf.findElement(By.xpath(".."));
        cb = $(CheckBoxElement.class).first();
        cbSlot = cb.findElement(By.xpath(".."));

        // Doing anything with the textfield or checkbox should not affect
        // layout

        tf.setValue("a");
        assertSizes();
        cb.click();
        assertSizes();
        tf.setValue("b");
        assertSizes();
        cb.click();
        assertSizes();

    }

    private void assertSizes() {
        if (tfSize == null) {
            tfSize = tf.getSize();
            tfSlotSize = tfSlot.getSize();
            cbSize = cb.getSize();
            cbSlotSize = cbSlot.getSize();
        } else {
            Assert.assertEquals(tfSize, tf.getSize());
            Assert.assertEquals(tfSlotSize, tfSlot.getSize());
            Assert.assertEquals(cbSize, cb.getSize());
            Assert.assertEquals(cbSlotSize, cbSlot.getSize());
        }

    }
}
