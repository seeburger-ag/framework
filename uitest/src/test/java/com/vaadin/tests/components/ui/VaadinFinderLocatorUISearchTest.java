/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.ui;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.testbench.elements.UIElement;
import com.vaadin.tests.components.button.ButtonClick;
import com.vaadin.tests.tb3.MultiBrowserTest;

/**
 *
 * @since
 * @author Vaadin Ltd
 */
public class VaadinFinderLocatorUISearchTest extends MultiBrowserTest {

    @Override
    protected Class<?> getUIClass() {
        return ButtonClick.class;
    }

    @Test
    public void getUIElementTest() {
        openTestURL();
        UIElement ui = $(UIElement.class).first();
        Assert.assertNotNull("Couldn't find the UI Element on the page", ui);
    }
}
