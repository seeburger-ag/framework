/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.ui;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.vaadin.tests.tb3.MultiBrowserTest;

public class TimeoutRedirectResetsOnActivityTest extends MultiBrowserTest {

    private int waitBeforeActivity = 4000;
    private int communicationOverhead = 2000;

    private static int i = 0;

    @Test
    @Ignore("The test modifies the system messages, which are global and the changes will affect other tests")
    public void verifyRedirectWorks() throws Exception {
        setDebug(true);
        openTestURL();

        long startedTime = getTime("startedTime");
        long originalExpireTime = getTime("originalExpireTime");

        Thread.sleep(waitBeforeActivity);
        hitButton("reset");

        Thread.sleep(200);

        long actualExpireTime = getTime("actualExpireTime");

        Thread.sleep(originalExpireTime - startedTime - waitBeforeActivity);

        assertThat(driver.getCurrentUrl(), is(getTestUrl()));

        testBench().disableWaitForVaadin();
        Thread.sleep(
                actualExpireTime - originalExpireTime + communicationOverhead);

        assertThat(driver.getCurrentUrl(), is(not(getTestUrl())));
    }

    private long getTime(String id) {
        WebElement element = vaadinElementById(id);
        return Long.parseLong(element.getText());
    }

    @Override
    protected String getTestUrl() {
        return super.getTestUrl() + "?restartApplication";
    }
}
