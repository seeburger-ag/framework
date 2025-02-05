/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.layouts.layouttester.VLayout;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.interactions.Actions;

import com.vaadin.testbench.elements.CheckBoxElement;
import com.vaadin.tests.layouts.layouttester.BaseLayoutRegErrorTest;

/**
 *
 * @since
 * @author Vaadin Ltd
 */
public class VLayoutRegErrorTest extends BaseLayoutRegErrorTest {

    @Override
    public void LayoutRegError() throws IOException {
        super.LayoutRegError();

        // The layout is too high to fit into one screenshot, we need to scroll
        // and take another.

        List<CheckBoxElement> checkBoxes = $(CheckBoxElement.class).all();
        assertEquals(3, checkBoxes.size());
        CheckBoxElement lastCheckBox = checkBoxes.get(2);

        new Actions(driver).moveToElement(lastCheckBox).build().perform();

        compareScreen("RegError-Scrolled");
    }
}
