/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.shared.ui;

import java.util.HashMap;
import java.util.Map;

import com.vaadin.shared.AbstractComponentState;

public class BrowserWindowOpenerState extends AbstractComponentState {
    public static final String locationResource = "url";

    public String target = "_blank";

    public String features;

    public String uriFragment;

    public Map<String, String> parameters = new HashMap<String, String>();

}
