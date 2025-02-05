/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.push;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import com.vaadin.testbench.elements.NativeSelectElement;
import com.vaadin.testbench.parallel.TestCategory;
import com.vaadin.tests.tb3.MultiBrowserTest;

@TestCategory("push")
abstract class PushConfigurationTest extends MultiBrowserTest {

    @Override
    protected Class<?> getUIClass() {
        return PushConfiguration.class;
    }

    @Override
    public void setup() throws Exception {
        super.setup();
        setDebug(true);

        openTestURL("restartApplication");
        disablePush();
    }

    protected String getStatusText() {
        WebElement statusLabel = vaadinElementById("status");

        return statusLabel.getText();
    }

    protected void disablePush() throws InterruptedException {
        getPushModeSelect().selectByText("Disabled");

        int counter = getServerCounter();
        sleep(2000);
        assertEquals("Server count changed without push enabled", counter,
                getServerCounter());
    }

    protected NativeSelectElement getPushModeSelect() {
        return $(NativeSelectElement.class).caption("Push mode").first();
    }

    protected NativeSelectElement getTransportSelect() {
        return $(NativeSelectElement.class).caption("Transport").first();
    }

    protected int getServerCounter() {
        return Integer.parseInt(getServerCounterElement().getText());
    }

    protected WebElement getServerCounterElement() {
        return vaadinElement(
                "/VVerticalLayout[0]/Slot[1]/VVerticalLayout[0]/Slot[5]/VLabel[0]");
    }

    protected void waitForServerCounterToUpdate() {
        int counter = getServerCounter();
        final int waitCounter = counter + 2;
        waitUntil(new ExpectedCondition<Boolean>() {

            @Override
            public Boolean apply(WebDriver input) {
                return (getServerCounter() >= waitCounter);
            }
        });
    }
}
