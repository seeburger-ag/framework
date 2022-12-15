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
import com.vaadin.shared.ui.JavaScriptComponentState;
import com.vaadin.tests.components.AbstractTestUIWithLog;
import com.vaadin.ui.AbstractJavaScriptComponent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class JavaScriptNoLayoutHandlingUI extends AbstractTestUIWithLog {

    public static class MyJSComponentState extends JavaScriptComponentState {
        // Using public methods as these are handled before public fields in the
        // parent
        private int aaa = 1;

        public int getAaa() {
            return aaa;
        }

        public void setAaa(int aaa) {
            this.aaa = aaa;
        }
    }

    @JavaScript("MyJS.js")
    public static class MyJsComponent extends AbstractJavaScriptComponent {

        @Override
        protected MyJSComponentState getState() {
            return (MyJSComponentState) super.getState();
        }
    }

    @Override
    protected void setup(VaadinRequest request) {
        final MyJsComponent myComponent = new MyJsComponent();
        myComponent.setId("js");
        addComponent(myComponent);
        addComponent(new Button("Send update", new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                myComponent.getState().aaa++;
            }

        }));

    }

}
