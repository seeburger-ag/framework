/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.push;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

public class PushWithPreserveOnRefreshTest extends MultiBrowserTest {

    @Test
    public void ensurePushWorksAfterRefresh() {
        openTestURL();
        $(ButtonElement.class).first().click();
        $(ButtonElement.class).first().click();
        Assert.assertEquals("2. Button has been clicked 2 times", getLogRow(0));
        openTestURL();
        Assert.assertEquals("2. Button has been clicked 2 times", getLogRow(0));
        $(ButtonElement.class).first().click();
        Assert.assertEquals("3. Button has been clicked 3 times", getLogRow(0));

    }
}
