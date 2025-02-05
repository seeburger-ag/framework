/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.fieldgroup;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BooleanTextFieldTest extends BasicPersonFormTest {

    @Override
    protected boolean requireWindowFocusForIE() {
        return true;
    }

    @Test
    public void testSetBooleanTextField() throws Exception {
        openTestURL();

        getLastNameArea().clear();
        getLastNameArea().click();
        getLastNameArea().sendKeys("Dover");

        assertBeanValuesUnchanged();

        getDeceasedField().click();
        while (!getDeceasedField().getValue().isEmpty()) {
            getDeceasedField().sendKeys(Keys.BACK_SPACE);
        }
        getDeceasedField().sendKeys("false", Keys.ENTER);

        /* error indicator */
        Assert.assertEquals("Incorrect amount of error indicators on page.", 1,
                findElements(By.className("v-errorindicator")).size());
        Assert.assertEquals("false", getDeceasedField().getAttribute("value"));

        assertBeanValuesUnchanged();

        /* error message in tooltip */
        getDeceasedField().showTooltip();
        Assert.assertEquals("Could not convert value to Boolean",
                getTooltipErrorElement().getText());

        getDeceasedField().click();
        while (!getDeceasedField().getValue().isEmpty()) {
            getDeceasedField().sendKeys(Keys.BACK_SPACE);
        }
        getDeceasedField().sendKeys("YAY!", Keys.ENTER);

        /* no error indicator */
        Assert.assertFalse(isElementPresent(By.className("v-errorindicator")));

        assertCommitSuccessful();

        /* commit last name and new deceased status */
        showBeanValues();
        Assert.assertEquals(
                "4. Person [firstName=John, lastName=Dover, email=john@doe.com, age=64, sex=Male, address=Address [streetAddress=John street, postalCode=11223, city=John's town, country=USA], deceased=true, salary=null, salaryDouble=null, rent=null]",
                getLogRow(0));
    }

    @Override
    public List<DesiredCapabilities> getBrowsersToTest() {
        // this test also works on IEs, but Firefox has problems with tooltips
        return getBrowsersExcludingFirefox();
    }

}
