/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.label;

import com.vaadin.shared.AbstractComponentState;

public class LabelState extends AbstractComponentState {
    {
        primaryStyleName = "v-label";
    }
    public ContentMode contentMode = ContentMode.TEXT;
    public String text = "";
}
