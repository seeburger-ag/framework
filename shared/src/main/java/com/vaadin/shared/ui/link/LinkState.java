/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.link;

import com.vaadin.shared.AbstractComponentState;
import com.vaadin.shared.ui.BorderStyle;

public class LinkState extends AbstractComponentState {
    {
        primaryStyleName = "v-link";
    }
    public String name = "";
    public String target = null;
    public BorderStyle targetBorder = BorderStyle.DEFAULT;
    public int targetWidth = -1;
    public int targetHeight = -1;
}
