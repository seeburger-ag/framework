/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.combobox;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsEmptyCollection.empty;

import java.util.List;

import com.vaadin.tests.tb3.SingleBrowserTest;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.vaadin.testbench.By;
import com.vaadin.tests.tb3.newelements.ComboBoxElement;

public class ComboBoxEmptyItemsKeyboardNavigationTest
        extends SingleBrowserTest {

    @Test
    public void navigatingUpOnAnEmptyMenuDoesntThrowErrors() {
        setDebug(true);
        openTestURL();

        ComboBoxElement combobox = $(ComboBoxElement.class).first();
        combobox.sendKeys("a", Keys.ARROW_UP);

        List<WebElement> errors = findElements(By.className("SEVERE"));

        assertThat(errors, empty());
    }

    @Test
    public void selectingUsingEnterInAnEmptyMenu() {
        setDebug(true);
        openTestURL();

        ComboBoxElement combobox = $(ComboBoxElement.class).first();
        combobox.sendKeys("a", Keys.ENTER);

        List<WebElement> errors = findElements(By.className("SEVERE"));

        assertThat(errors, empty());

        assertPopupClosed(combobox);
    }

    @Test
    public void selectingUsingTabInAnEmptyMenu() {
        setDebug(true);
        openTestURL();

        ComboBoxElement combobox = $(ComboBoxElement.class).first();
        // The joy of testing, one tab should be enough but is not (it is
        // locally), two tabs does the trick for PhantomJS on the cluster...
        combobox.sendKeys("abc", Keys.TAB, Keys.TAB);

        List<WebElement> errors = findElements(By.className("SEVERE"));

        assertThat(errors, empty());
        assertPopupClosed(combobox);
    }

    private void assertPopupClosed(ComboBoxElement combobox) {
        org.openqa.selenium.By bySuggestionPopup = By.vaadin("#popup");

        assertThat("ComboBox popup should not be open",
                combobox.findElements(bySuggestionPopup).isEmpty());

    }
}