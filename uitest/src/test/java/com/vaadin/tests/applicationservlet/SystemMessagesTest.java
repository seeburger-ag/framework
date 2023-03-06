/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.applicationservlet;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.NativeSelectElement;
import com.vaadin.testbench.elements.NotificationElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

public class SystemMessagesTest extends MultiBrowserTest {

    @Test
    public void testFinnishLocaleInSystemErrorMessage() throws Exception {
        openTestURL();
        verifyError("fi_FI");
    }

    @Test
    public void testGermanLocaleInSystemErrorMessage() throws Exception {
        openTestURL();
        $(NativeSelectElement.class).first().selectByText("de_DE");
        verifyError("de_DE");
    }

    private void verifyError(String locale) {
        $(ButtonElement.class).first().click();
        NotificationElement notification = $(NotificationElement.class).first();
        Assert.assertEquals("Incorrect notification caption,",
                notification.getCaption(), "Internal error");
        Assert.assertEquals("Incorrect notification description,",
                notification.getDescription(),
                "MessagesInfo locale: " + locale);
    }
}
