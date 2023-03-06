/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.javascriptcomponent;

import com.vaadin.annotations.JavaScript;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.AbstractJavaScriptComponent;
import com.vaadin.ui.JavaScriptFunction;
import com.vaadin.ui.Label;

import elemental.json.JsonArray;

public class JSComponentLoadingIndicator extends AbstractTestUI {

    @JavaScript({ "JSComponent.js" })
    public class JSComponent extends AbstractJavaScriptComponent {
        public JSComponent() {
            addFunction("test", new JavaScriptFunction() {
                @Override
                public void call(JsonArray arguments) {
                    try {
                        Thread.sleep(1000);
                        Label label = new Label("pong");
                        label.addStyleName("pong");
                        addComponent(label);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    @Override
    protected void setup(VaadinRequest request) {
        addComponent(new JSComponent());
    }

}
