/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.validation;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;

import com.vaadin.testbench.elements.CheckBoxElement;
import com.vaadin.testbench.elements.TextFieldElement;
import com.vaadin.testbench.elements.VerticalLayoutElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

public class ValidationOfRequiredEmptyFieldsTest extends MultiBrowserTest {

    @Override
    protected boolean requireWindowFocusForIE() {
        return true;
    }

    @Override
    public List<DesiredCapabilities> getBrowsersToTest() {
        // Firefox causes extra mouseOut events breaking tooltips.
        return getBrowsersExcludingFirefox();
    }

    @Test
    public void requiredErrorMessage() throws Exception {
        openTestURL();
        getRequiredCheckbox().click();
        getRequiredMessageField().click();
        getRequiredMessageField().sendKeys("The field is required", Keys.TAB);
        assertTooltipError("The field is required");
    }

    @Test
    public void integerValidatorErrorMessage() {
        openTestURL();
        getRequiredCheckbox().click();
        getIntegerValidatorCheckbox().click();
        getTargetTextField().sendKeys("a", Keys.SHIFT, Keys.TAB);
        assertTooltipError("Must be an integer");
    }

    @Test
    public void requiredWithIntegerAndLengthValidatorErrorMessage() {
        openTestURL();
        getRequiredCheckbox().click();
        getIntegerValidatorCheckbox().click();
        getLengthValidatorCheckbox().click();
        getTargetTextField().sendKeys("a", Keys.SHIFT, Keys.TAB);
        assertTooltipError("Must be an integer\nMust be 5-10 chars");
    }

    @Test
    public void integerAndLengthValidatorErrorMessage() {
        openTestURL();
        getIntegerValidatorCheckbox().click();
        getLengthValidatorCheckbox().click();
        getTargetTextField().sendKeys("a", Keys.SHIFT, Keys.TAB);
        assertTooltipError("Must be an integer\nMust be 5-10 chars");
    }

    private void assertTooltipError(final String message) {
        TextFieldElement e = getTargetTextField();
        testBenchElement(e).showTooltip();
        waitUntil(new ExpectedCondition<Boolean>() {

            @Override
            public Boolean apply(WebDriver input) {
                return message.equals(getTooltipErrorElement().getText());
            }

            @Override
            public String toString() {
                return "tooltip to be '" + message + "' (was: '"
                        + getTooltipErrorElement().getText() + "')";
            }
        });
        hideTooltip();
    }

    private void hideTooltip() {
        $(VerticalLayoutElement.class).first().click();
    }

    private TextFieldElement getRequiredMessageField() {
        return $(TextFieldElement.class).all().get(0);
    }

    private TextFieldElement getTargetTextField() {
        return $(TextFieldElement.class).all().get(1);
    }

    private WebElement getRequiredCheckbox() {
        return $(CheckBoxElement.class).caption("Field required").first()
                .findElement(By.xpath("input"));
    }

    private WebElement getIntegerValidatorCheckbox() {
        return $(CheckBoxElement.class).caption("Integer validator").first()
                .findElement(By.xpath("input"));
    }

    private WebElement getLengthValidatorCheckbox() {
        return $(CheckBoxElement.class).caption("String length validator")
                .first().findElement(By.xpath("input"));
    }

}
