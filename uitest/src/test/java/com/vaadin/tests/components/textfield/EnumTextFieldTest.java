/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.textfield;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;

import com.vaadin.testbench.elements.TextFieldElement;
import com.vaadin.tests.tb3.SingleBrowserTest;

public class EnumTextFieldTest extends SingleBrowserTest {
    @Test
    public void validValues() {
        openTestURL();
        $(TextFieldElement.class).first().clear();
        $(TextFieldElement.class).first().sendKeys("Value", Keys.TAB);
        Assert.assertEquals("3. Value (valid)", getLogRow(0));

        $(TextFieldElement.class).first().clear();
        $(TextFieldElement.class).first().sendKeys("VaLuE");
        $(TextFieldElement.class).first().sendKeys(Keys.TAB);
        Assert.assertEquals("5. Value (valid)", getLogRow(0));

        $(TextFieldElement.class).first().clear();
        $(TextFieldElement.class).first().sendKeys("The last value");
        $(TextFieldElement.class).first().sendKeys(Keys.TAB);
        Assert.assertEquals("7. The last value (valid)", getLogRow(0));

        $(TextFieldElement.class).first().clear();
        Assert.assertEquals("8. null (valid)", getLogRow(0));

    }

    @Test
    public void invalidValue() {
        openTestURL();
        $(TextFieldElement.class).first().clear();

        $(TextFieldElement.class).first().sendKeys("bar");
        $(TextFieldElement.class).first().sendKeys(Keys.TAB);
        Assert.assertEquals("3. bar (INVALID)", getLogRow(0));

    }
}
