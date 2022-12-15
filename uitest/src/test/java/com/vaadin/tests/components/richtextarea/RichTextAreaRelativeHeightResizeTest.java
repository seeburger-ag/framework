/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.richtextarea;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.testbench.By;
import com.vaadin.tests.tb3.MultiBrowserTest;

public class RichTextAreaRelativeHeightResizeTest extends MultiBrowserTest {

    @Test
    public void testCenteredClosingAndPostLayout() {
        openTestURL();

        int originalHeight = driver
                .findElement(By.cssSelector(".v-richtextarea")).getSize()
                .getHeight();
        int originalEditorHeight = driver
                .findElement(By.cssSelector(".v-richtextarea iframe")).getSize()
                .getHeight();

        // Increase the component height
        driver.findElement(By.cssSelector(".v-button")).click();

        int newHeight = driver.findElement(By.cssSelector(".v-richtextarea"))
                .getSize().getHeight();
        int newEditorHeight = driver
                .findElement(By.cssSelector(".v-richtextarea iframe")).getSize()
                .getHeight();

        // Check that the component height changed and that the editor height
        // changed equally as much
        Assert.assertTrue("RichTextArea height didn't change",
                newHeight != originalHeight);
        Assert.assertEquals(
                "Editor height change didn't match the Component height change",
                newHeight - originalHeight,
                newEditorHeight - originalEditorHeight);
    }
}
