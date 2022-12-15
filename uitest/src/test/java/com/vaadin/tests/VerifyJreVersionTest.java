/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.vaadin.tests.tb3.SingleBrowserTest;

public class VerifyJreVersionTest extends SingleBrowserTest {

    @Test
    public void verifyJreVersion() {
        openTestURL();

        WebElement jreVersionLabel = vaadinElementById("jreVersionLabel");

        assertThat(jreVersionLabel.getText(),
                is("Using Java 1.8.0_201 by Oracle Corporation"));
    }

}
