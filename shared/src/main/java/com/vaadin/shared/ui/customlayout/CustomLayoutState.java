/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.customlayout;

import java.util.HashMap;
import java.util.Map;

import com.vaadin.shared.Connector;
import com.vaadin.shared.ui.AbstractLayoutState;

public class CustomLayoutState extends AbstractLayoutState {
    {
        primaryStyleName = "v-customlayout";
    }
    public Map<Connector, String> childLocations = new HashMap<Connector, String>();
    public String templateContents;
    public String templateName;
}
