/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.layouts;

import com.vaadin.tests.tb3.SingleBrowserTest;
import org.junit.Assert;
import org.junit.Test;

import com.vaadin.testbench.elements.FormLayoutElement;
import com.vaadin.testbench.elements.TextFieldElement;

public class RelativeSizeInUndefinedCssLayoutTest
        extends SingleBrowserTest {

    @Test
    public void relativeSizeInUndefinedCssLayout() {
        openTestURL();
        int w = $(FormLayoutElement.class).first().getSize().getWidth();
        Assert.assertEquals(w, 520);

        int w2 = $(TextFieldElement.class).first().getSize().getWidth();
        Assert.assertTrue(w2 > 400);
    }
}
