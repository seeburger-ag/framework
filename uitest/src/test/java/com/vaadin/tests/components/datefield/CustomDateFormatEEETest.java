/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.datefield;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;

import com.vaadin.tests.tb3.MultiBrowserTest;

public class CustomDateFormatEEETest extends MultiBrowserTest {

    @Test
    public void verifyDatePattern() {
        openTestURL();

        String dateValue = driver
                .findElement(By.className("v-datefield-textfield"))
                .getAttribute("value");
        assertEquals("14/03/2014 Fri", dateValue);
    }

}
