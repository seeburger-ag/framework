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

import com.vaadin.testbench.parallel.TestCategory;
import com.vaadin.tests.tb3.MultiBrowserTest;

@TestCategory("push")
public abstract class IdlePushChannelTest extends MultiBrowserTest {

    private static final int SEVEN_MINUTES_IN_MS = 7 * 60 * 1000;

    @Test
    public void longWaitBetweenActions() throws Exception {
        openTestURL();
        BasicPushTest.getIncrementButton(this).click();
        Assert.assertEquals(1, BasicPushTest.getClientCounter(this));
        sleep(SEVEN_MINUTES_IN_MS);
        BasicPushTest.getIncrementButton(this).click();
        Assert.assertEquals(2, BasicPushTest.getClientCounter(this));
    }

}
