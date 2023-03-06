/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.layouts.layouttester;

import com.vaadin.ui.Label;

public class UndefWideLabel extends Label {

    public UndefWideLabel(String value) {
        super(value);
        setWidth(null);
    }

}
