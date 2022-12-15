/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.ui;

import com.vaadin.annotations.Viewport;
import com.vaadin.annotations.ViewportGeneratorClass;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.tests.components.ui.DynamicViewport.MyViewportGenerator;
import com.vaadin.ui.Label;

@ViewportGeneratorClass(MyViewportGenerator.class)
@Viewport("myViewport")
public class InvalidViewport extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        addComponent(new Label(
                "I shouldn't load because of conflicting viewport definitions"));

    }

}
