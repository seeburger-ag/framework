/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.button;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class Buttons3<T extends Button> extends Buttons2<T>
        implements ClickListener {

    @Override
    public void buttonClick(ClickEvent event) {
        event.getButton().setEnabled(true);
        super.buttonClick(event);
    }

}
