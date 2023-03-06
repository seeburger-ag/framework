/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.absolutelayout;

import java.util.HashMap;
import java.util.Map;

import com.vaadin.shared.ui.AbstractLayoutState;

public class AbsoluteLayoutState extends AbstractLayoutState {
    {
        primaryStyleName = "v-absolutelayout";
    }

    // Maps each component to a position
    public Map<String, String> connectorToCssPosition = new HashMap<String, String>();
}
