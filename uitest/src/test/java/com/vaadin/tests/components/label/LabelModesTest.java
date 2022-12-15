/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.label;

import org.junit.Test;

import com.vaadin.tests.tb3.MultiBrowserTest;

public class LabelModesTest extends MultiBrowserTest {

    @Test
    public void testLabelModes() throws Exception {
        openTestURL();
        compareScreen("labelmodes");
    }

}
