/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.minitutorials.v7a3;

import com.vaadin.annotations.StyleSheet;
import com.vaadin.ui.NativeButton;

@StyleSheet("redbutton.css")
public class RedButton extends NativeButton {
    public RedButton(String caption) {
        super(caption);
        addStyleName("redButton");
    }
}
