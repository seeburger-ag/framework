/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.widgetset.client;

import com.vaadin.shared.AbstractComponentState;

/**
 * State class with the same simple name as
 * {@link com.vaadin.shared.ui.label.LabelState} to test #8683
 *
 * @author Vaadin Ltd
 * @version @VERSION@
 * @since 7.0.0
 */
public class LabelState extends AbstractComponentState {

    private String text;

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
