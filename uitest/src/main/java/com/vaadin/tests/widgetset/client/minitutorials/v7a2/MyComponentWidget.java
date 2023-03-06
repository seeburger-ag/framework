/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.widgetset.client.minitutorials.v7a2;

import com.google.gwt.user.client.ui.Label;

public class MyComponentWidget extends Label {
    public static final String CLASSNAME = "mycomponent";

    public MyComponentWidget() {
        setText("This is MyComponent");
        setStyleName(CLASSNAME);
    }
}
