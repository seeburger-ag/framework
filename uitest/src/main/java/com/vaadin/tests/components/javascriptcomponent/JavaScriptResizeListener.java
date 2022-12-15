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
import com.vaadin.data.Property;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.AbstractJavaScriptComponent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.CssLayout;

public class JavaScriptResizeListener extends AbstractTestUI {

    @JavaScript("ResizeJsConnector.js")
    public class ResizeJsComponent extends AbstractJavaScriptComponent {
        public void setListenerEnabled(boolean enabled) {
            callFunction("setListenerEnabled", Boolean.valueOf(enabled));
        }
    }

    private final ResizeJsComponent resizeJsComponent = new ResizeJsComponent();

    private final CssLayout holder = new CssLayout();

    @Override
    protected void setup(VaadinRequest request) {

        addComponent(
                new Button("Change holder size", new Button.ClickListener() {
                    @Override
                    public void buttonClick(ClickEvent event) {
                        updateHolderSize();
                    }
                }));
        addComponent(new CheckBox("Listener active") {
            {
                setImmediate(true);
                addValueChangeListener(new ValueChangeListener() {
                    @Override
                    public void valueChange(Property.ValueChangeEvent event) {
                        resizeJsComponent.setListenerEnabled(
                                event.getProperty().getValue() == Boolean.TRUE);
                    }
                });
            }
        });

        updateHolderSize();
        addComponent(holder);

        resizeJsComponent.setSizeFull();
        holder.addComponent(resizeJsComponent);
    }

    private void updateHolderSize() {
        if (holder.getHeight() == 100) {
            holder.setHeight("50px");
        } else {
            holder.setHeight("100px");
        }

        if (holder.getWidth() == 100) {
            holder.setWidth("200px");
        } else {
            holder.setWidth("100px");
        }
    }

    @Override
    protected String getTestDescription() {
        return "Test for getting resize events for javascript components";
    }

    @Override
    protected Integer getTicketNumber() {
        return Integer.valueOf(11996);
    }

}
