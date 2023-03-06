/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.slider;

import com.vaadin.data.Item;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Slider;
import com.vaadin.ui.Table;

public class HiddenSliderHandle extends AbstractTestUI {

    private static final long serialVersionUID = 1L;

    @Override
    protected void setup(VaadinRequest request) {
        Table t = new Table();
        Slider s = new Slider();
        t.setWidth("200px");
        s.setWidth("100px");
        t.addContainerProperty("s", Slider.class, null);
        Item i = t.addItem("123");
        i.getItemProperty("s").setValue(s);
        getLayout().addComponent(t);
    }

    @Override
    protected String getTestDescription() {
        return "Slider's handler should be accessible (visible) if slider is put inside table";
    }

    @Override
    protected Integer getTicketNumber() {
        return 13681;
    }

}
