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
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Slider;
import com.vaadin.ui.VerticalLayout;

public class SliderDisable extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        VerticalLayout content = new VerticalLayout();
        content.setMargin(true);
        content.setSpacing(true);

        final Slider slider = new Slider(0, 5);
        slider.setWidth(200, Unit.PIXELS);
        slider.setValue(1.0D);

        Button disableButton = new Button("Disable slider");
        disableButton.setId("disableButton");
        disableButton.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                slider.setEnabled(false);
            }
        });

        content.addComponent(slider);
        content.addComponent(disableButton);
        setContent(content);
    }

    @Override
    protected String getTestDescription() {
        return "The apparent value of the slider should not change when the slider is disabled";
    }

    @Override
    protected Integer getTicketNumber() {
        return 12676;
    }

}
