/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.ui;

import com.vaadin.annotations.ViewportGeneratorClass;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.ViewportGenerator;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.tests.components.ui.DynamicViewport.MyViewportGenerator;
import com.vaadin.ui.Label;

@ViewportGeneratorClass(MyViewportGenerator.class)
public class DynamicViewport extends AbstractTestUI {

    public static final String VIEWPORT_DISABLE_PARAMETER = "noViewport";

    public static class MyViewportGenerator implements ViewportGenerator {
        @Override
        public String getViewport(VaadinRequest request) {
            if (request.getParameterMap()
                    .containsKey(VIEWPORT_DISABLE_PARAMETER)) {
                return null;
            }
            return request.getHeader("User-Agent");
        }
    }

    @Override
    protected void setup(VaadinRequest request) {
        String negation = request.getParameterMap()
                .containsKey(VIEWPORT_DISABLE_PARAMETER) ? "not " : "";
        addComponent(new Label(
                "I should " + negation + "have a dynamic viewport tag"));
    }
}