/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.layouts.layouttester;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

/**
 *
 * @since
 * @author Vaadin Ltd
 */
public abstract class BaseLayoutSizingTest extends MultiBrowserTest {
    protected String[] states = new String[] { "setSize350px", "setSize_-1px",
            "setSize75Percent", "setSize100Percent" };

    @Test
    public void LayoutSizing() throws IOException, InterruptedException {
        openTestURL();
        sleep(500);
        compareScreen("initial");
        List<ButtonElement> buttons = $(ButtonElement.class).all();
        int index = 0;
        // go through all buttons click them and see result
        for (ButtonElement btn : buttons) {
            btn.click();
            sleep(500);
            compareScreen(states[index]);
            index++;
        }
    }

}