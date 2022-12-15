/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.integration.websocket;

import static org.junit.Assert.assertEquals;

import java.util.*;

import org.junit.Assume;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.vaadin.testbench.By;
import com.vaadin.tests.integration.AbstractServletIntegrationTest;

public class ServletIntegrationWebsocketIT
        extends AbstractServletIntegrationTest {
    // Uses the test method declared in the super class

    private static final Set<String> nonWebsocketServers = new HashSet<String>();

    static {
        nonWebsocketServers.add("liberty-microprofile");
    }

    @Override
    public void setup() throws Exception {
        Assume.assumeFalse("This server does not support Websockets",
                nonWebsocketServers
                        .contains(System.getProperty("server-name")));

        super.setup();
    }

    @Override
    protected String getTestPath() {
        return "/run/ServletIntegrationWebsocketUI";
    }

    @Test
    public void testWebsockedUsed() {
        List<String> params = new ArrayList<String>();
        for (String param : getParameters()) {
            params.add(param);
        }
        params.add("debug");

        // Reopen the page with debug window
        openTestURL(params.toArray(new String[params.size()]));

        // Make sure the correct debug window tab is open.
        findElements(By.className("v-debugwindow-tab")).get(1).click();

        try {
            // Wait to make sure correct tab is shown.
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        WebElement row = findElements(By.className("v-debugwindow-row")).get(7);
        assertEquals("Communication method",
                row.findElement(By.className("caption")).getAttribute("innerText"));
        assertEquals("Client to server: websocket, server to client: websocket",
                row.findElement(By.className("value")).getAttribute("innerText"));
    }
}
