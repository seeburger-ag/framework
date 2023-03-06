/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui;

import com.google.gwt.user.client.ui.Image;

public class VImage extends Image {

    public static final String CLASSNAME = "v-image";

    public VImage() {
        setStylePrimaryName(CLASSNAME);
    }
}
