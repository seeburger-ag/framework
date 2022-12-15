/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid;

import com.vaadin.data.Container.Indexed;
import com.vaadin.ui.Grid;

public class GridSubclass extends Grid {

    public GridSubclass(Indexed dataSource) {
        super(dataSource);
    }
}
