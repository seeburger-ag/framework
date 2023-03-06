/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.combobox;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUIWithLog;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;

/**
 * Test UI for adding a stylename to a combobox with an undefined width.
 *
 * @author Vaadin Ltd
 */
public class ComboboxStyleChangeWidth extends AbstractTestUIWithLog {

    @Override
    protected void setup(VaadinRequest request) {
        final ComboBox cbFoo = new ComboBox();
        cbFoo.setImmediate(true);
        cbFoo.setSizeUndefined();
        cbFoo.addItem(
                "A really long string that causes an inline width to be set");

        Button btn = new Button("Click to break CB",
                new Button.ClickListener() {
                    @Override
                    public void buttonClick(ClickEvent event) {
                        cbFoo.addStyleName("foofoo");

                    }
                });

        addComponent(cbFoo);
        addComponent(btn);

    }

    @Override
    protected String getTestDescription() {
        return "The computed inline width of an undefined-width ComboBox "
                + "(with a sufficiently long option string) breaks when "
                + "the component's stylename is changed after initial "
                + "rendering.";
    }

    @Override
    protected Integer getTicketNumber() {
        return Integer.valueOf(13444);
    }

}
