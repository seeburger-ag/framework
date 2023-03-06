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
package com.vaadin.tests.components.slider;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Slider;

/**
 * Testcase for #12133
 *
 * @author Vaadin Ltd
 */
public class SliderUpdateFromValueChange extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        final Slider slider = new Slider(0, 100, 1);
        slider.addValueChangeListener(new ValueChangeListener() {

            @Override
            public void valueChange(ValueChangeEvent event) {
                Double value = (Double) event.getProperty().getValue();
                if (value < 100.0) {
                    slider.setValue(100.0);
                }
                slider.markAsDirty();
            }

        });
        slider.setImmediate(true);
        slider.setWidth(200, Unit.PIXELS);

        addComponent(slider);
    }

    @Override
    protected String getTestDescription() {
        return "Slider.setValue() does not update graphical representation of Slider component";
    }

    @Override
    protected Integer getTicketNumber() {
        return 12133;
    }
}
