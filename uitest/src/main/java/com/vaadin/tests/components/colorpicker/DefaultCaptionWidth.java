/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.colorpicker;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ColorPicker;

/**
 * Test for color picker with default caption.
 *
 * @author Vaadin Ltd
 */
public class DefaultCaptionWidth extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        final ColorPicker colorPicker = new ColorPicker();
        addComponent(colorPicker);
        colorPicker.setDefaultCaptionEnabled(true);

        Button setWidth = new Button("Set explicit width",
                new Button.ClickListener() {

                    @Override
                    public void buttonClick(ClickEvent event) {
                        colorPicker.setCaption(null);
                        colorPicker.setWidth("150px");
                    }
                });
        setWidth.addStyleName("set-width");
        addComponent(setWidth);

        Button setCaption = new Button("Set explicit caption",
                new Button.ClickListener() {

                    @Override
                    public void buttonClick(ClickEvent event) {
                        colorPicker.setCaption("caption");
                        colorPicker.setWidthUndefined();
                    }
                });
        setCaption.addStyleName("set-caption");
        addComponent(setCaption);

    }

    @Override
    protected String getTestDescription() {
        return "Color picker with default caption enabled should get appropriate style";
    }

    @Override
    protected Integer getTicketNumber() {
        return 17140;
    }
}
