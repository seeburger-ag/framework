/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

/**
 *
 */
package com.vaadin.tests.components.button;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;

/**
 *
 * @since
 * @author Vaadin Ltd
 */
public class ButtonUpdateAltText extends AbstractTestUI {

    private final ThemeResource ICON = new ThemeResource(
            "../runo/icons/16/folder.png");

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.tests.components.AbstractTestUI#setup(com.vaadin.server.
     * VaadinRequest)
     */
    @Override
    protected void setup(VaadinRequest request) {
        final Button btn = new Button();
        btn.setId("button");
        btn.setIcon(ICON, "initial alt text");
        addComponent(btn);

        final CheckBox enable = new CheckBox("Enable alt text", true);
        enable.setImmediate(true);
        enable.addValueChangeListener(new Property.ValueChangeListener() {

            @Override
            public void valueChange(ValueChangeEvent event) {
                if (enable.booleanValue()) {
                    btn.setIconAlternateText("alt text");
                } else {
                    btn.setIconAlternateText("");
                }
            }
        });
        addComponent(enable);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.tests.components.AbstractTestUI#getTestDescription()
     */
    @Override
    protected String getTestDescription() {
        return "Button should have a alt text";
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.tests.components.AbstractTestUI#getTicketNumber()
     */
    @Override
    protected Integer getTicketNumber() {
        return 12333;
    }

}
