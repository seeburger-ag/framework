/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.themes.chameleon;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.NotificationElement;
import com.vaadin.tests.tb3.MultiBrowserTest;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class ChameleonNotificationTest extends MultiBrowserTest {
    @Test
    public void gradientPathIsCorrect() throws IOException {
        openTestURL();
        $(ButtonElement.class).first().click();

        NotificationElement notificationElement = $(NotificationElement.class)
                .first();

        assertThat(notificationElement.getCssValue("background-image"),
                containsString("chameleon/img/grad"));
    }
}