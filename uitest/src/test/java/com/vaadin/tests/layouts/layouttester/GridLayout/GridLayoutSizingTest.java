/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.layouts.layouttester.GridLayout;

import java.io.IOException;

import com.vaadin.tests.layouts.layouttester.BaseLayoutSizingTest;

/**
 *
 * @since
 * @author Vaadin Ltd
 */
public class GridLayoutSizingTest extends BaseLayoutSizingTest {

    @Override
    public void LayoutSizing() throws IOException, InterruptedException {
        states[0] = "setSize600px";
        super.LayoutSizing();
    }
}