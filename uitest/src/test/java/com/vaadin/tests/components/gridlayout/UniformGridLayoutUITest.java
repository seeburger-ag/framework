/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.gridlayout;

import org.junit.Test;

import com.vaadin.tests.tb3.MultiBrowserTest;

public class UniformGridLayoutUITest extends MultiBrowserTest {

    @Test
    public void noncollapsed() throws Exception {
        openTestURL();
        compareScreen("noncollapsed");
    }

    @Test
    public void collapsed() throws Exception {
        openTestURL("collapse");
        compareScreen("collapsed");
    }
}
