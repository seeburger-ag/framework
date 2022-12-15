/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid.basicfeatures.client;

import org.junit.Before;

public class GridClientCompositeHeaderTest extends GridHeaderTest {

    @Before
    public void setUp() {
        setUseComposite(true);
    }
}
