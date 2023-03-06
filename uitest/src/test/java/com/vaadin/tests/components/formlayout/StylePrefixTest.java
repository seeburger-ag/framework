/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.formlayout;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import com.vaadin.tests.tb3.MultiBrowserTest;

/**
 * Test for FormLayout style prefix: custom additional styles should be prefixed
 * with "v-formlayout-", not "v-layout-".
 *
 * @author Vaadin Ltd
 */
public class StylePrefixTest extends MultiBrowserTest {

    @Test
    public void testStylePrefix() {
        openTestURL();

        Assert.assertTrue("Custom style has unexpected prefix",
                isElementPresent(By.className("v-formlayout-mystyle")));
    }

}
