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
import com.vaadin.ui.Slider;

public class SliderFeedback extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        Slider slider = new Slider(0, 5);
        slider.setWidth(800, Unit.PIXELS);
        slider.setMin(0);
        slider.setMax(1e12);
        addComponent(slider);
    }

    @Override
    protected String getTestDescription() {
        return "Slider feedback popup should display the correct value";
    }

    @Override
    protected Integer getTicketNumber() {
        return 18192;
    }

}
