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
import static org.hamcrest.Matchers.is;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;

import com.vaadin.client.ui.VFilterSelect;
import com.vaadin.tests.tb3.MultiBrowserTest;
import com.vaadin.tests.tb3.newelements.ComboBoxElement;

/**
 * ComboBox suggestion popup should not obscure the text input box.
 *
 * @author Vaadin Ltd
 */
public class ComboBoxOnSmallScreenTest extends MultiBrowserTest {

    private static final Dimension TARGETSIZE = new Dimension(600, 300);
    private static final String POPUPCLASSNAME = VFilterSelect.CLASSNAME
            + "-suggestpopup";

    ComboBoxElement combobox;
    WebElement popup;

    @Override
    public void setup() throws Exception {
        super.setup();

        openTestURL();

        getWindow().setSize(TARGETSIZE);

        combobox = $(ComboBoxElement.class).first();
        combobox.openPopup();

        popup = findElement(By.className(POPUPCLASSNAME));
    }

    @Test
    public void testSuggestionPopupOverlayPosition() {
        final int popupTop = popup.getLocation().y;
        final int popupBottom = popupTop + popup.getSize().getHeight();
        final int cbTop = combobox.getLocation().y;
        final int cbBottom = cbTop + combobox.getSize().getHeight();

        assertThat("Popup overlay overlaps with the textbox",
                popupTop >= cbBottom || popupBottom <= cbTop, is(true));
    }

    @Test
    public void testSuggestionPopupOverlaySize() {
        final int popupTop = popup.getLocation().y;
        final int popupBottom = popupTop + popup.getSize().getHeight();
        final int rootHeight = findElement(By.tagName("body")).getSize().height;

        assertThat("Popup overlay out of the screen",
                popupTop < 0 || popupBottom > rootHeight, is(false));
    }

    private Window getWindow() {
        return getDriver().manage().window();
    }

}
