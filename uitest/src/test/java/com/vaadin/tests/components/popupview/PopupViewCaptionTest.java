/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.popupview;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.vaadin.testbench.By;
import com.vaadin.tests.tb3.MultiBrowserTest;

/**
 *
 * @author Vaadin Ltd
 */
public class PopupViewCaptionTest extends MultiBrowserTest {

    @Test
    public void testCaption() {
        openTestURL();

        WebElement caption = driver.findElement(By.className("v-caption"));
        Assert.assertNotNull(caption);

        List<WebElement> elements = caption.findElements(By.xpath("*"));

        boolean foundCaptionText = false;
        for (WebElement element : elements) {
            if ("Popup Caption:".equals(element.getText())) {
                foundCaptionText = true;
                break;
            }
        }
        Assert.assertTrue("Unable to find caption text", foundCaptionText);
    }

}
