/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.slider;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Slider;
import com.vaadin.ui.VerticalLayout;

public class SliderResize extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setSpacing(true);
        layout.setWidth("500px");
        addComponent(layout);

        Slider slider = new Slider();
        slider.setId("horizontal");
        slider.setValue(100.0);
        slider.setWidth("100%");

        Button changeWidth = new Button("Set layout width to 300px",
                new Button.ClickListener() {

                    @Override
                    public void buttonClick(ClickEvent event) {
                        layout.setWidth("300px");
                    }
                });
        layout.addComponents(slider, changeWidth);
    }

    @Override
    protected String getTestDescription() {
        return "Slider handle should be updated to correct position when the component size changes";
    }

    @Override
    protected Integer getTicketNumber() {
        return 12550;
    }

}
