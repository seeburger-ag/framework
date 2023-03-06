/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.ui;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.vaadin.tests.tb3.SingleBrowserTest;

/**
 *
 * @since
 * @author Vaadin Ltd
 */
public class UnnecessaryPaddingInResponsiveUITest extends SingleBrowserTest {

    @Test
    public void testUIShouldHaveNoPaddingTop() {
        openTestURL();

        WebElement ui = vaadinElementById("UI");

        String paddingTop = ui.getCssValue("padding-top");

        Integer paddingHeight = Integer
                .parseInt(paddingTop.substring(0, paddingTop.length() - 2));

        assertThat(paddingHeight, equalTo(0));

    }
}
