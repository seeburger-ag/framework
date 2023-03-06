/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.layout;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import com.vaadin.tests.tb3.MultiBrowserTest;

/**
 * Test to make sure that there is no any empty space (in Google Chrome) on page
 * after expanded component (#12672)
 *
 * Layout:
 *
 * [ Panel (auto x auto) [ Grid (auto x auto) ]
 *
 * AnyComponent (100% x 100%)
 *
 * <HERE SHOULD NOT BE ANY EMPTY SPACE> ]
 *
 * @author Vaadin Ltd
 */
public class EmptySpaceOnPageAfterExpandedComponentTest
        extends MultiBrowserTest {

    @Test
    public void testNoEmptySpaceOnPageAfterExpandedComponent() {
        openTestURL();

        final WebElement expandedElement = vaadinElementById("expandedElement");
        final WebElement containerElement = vaadinElementById("container");

        waitUntil(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver input) {
                int expandedElementBottom = expandedElement.getLocation().getY()
                        + expandedElement.getSize().getHeight();
                int containerElementBottom = containerElement.getLocation()
                        .getY() + containerElement.getSize().getHeight();

                return expandedElementBottom + 1 == containerElementBottom;
            }
        });
    }
}
