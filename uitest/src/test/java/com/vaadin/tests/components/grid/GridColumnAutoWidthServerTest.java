/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid;

import com.vaadin.testbench.parallel.TestCategory;

@TestCategory("grid")
public class GridColumnAutoWidthServerTest
        extends AbstractGridColumnAutoWidthTest {
    @Override
    protected Class<?> getUIClass() {
        return GridColumnAutoWidth.class;
    }
}