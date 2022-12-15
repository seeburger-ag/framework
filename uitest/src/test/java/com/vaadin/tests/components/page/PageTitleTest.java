/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.page;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.tests.tb3.MultiBrowserTest;

public class PageTitleTest extends MultiBrowserTest {

    @Test
    public void nullTitle() {
        driver.get(getTestUrl());
        Assert.assertEquals(PageTitle.class.getName(), driver.getTitle());
    }

    @Test
    public void fooTitle() {
        driver.get(getTestUrl() + "?title=foo");
        Assert.assertEquals("foo", driver.getTitle());
    }
}
