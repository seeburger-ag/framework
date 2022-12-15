/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.widgetset.client;

import com.vaadin.client.ui.VLabel;

/**
 * Client-side implementation for IdTestLabel (#10179).
 *
 */
public class VIdTestLabel extends VLabel {

    public VIdTestLabel() {
        super();
        getElement().setId("default10179");
    }
}
