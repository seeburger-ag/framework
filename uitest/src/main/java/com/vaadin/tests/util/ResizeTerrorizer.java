/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.util;

import com.vaadin.tests.widgetset.client.ResizeTerrorizerControlConnector.ResizeTerorrizerState;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;

public class ResizeTerrorizer extends VerticalLayout {
    private final ResizeTerrorizerControl control;

    public class ResizeTerrorizerControl extends AbstractComponent
            implements Component {

        public ResizeTerrorizerControl(Component target) {
            getState().target = target;
        }

        @Override
        protected ResizeTerorrizerState getState() {
            return (ResizeTerorrizerState) super.getState();
        }
    }

    public ResizeTerrorizer(Component target) {
        target.setWidth("700px");
        setSizeFull();
        addComponent(target);
        setExpandRatio(target, 1);
        control = new ResizeTerrorizerControl(target);
        addComponent(control);
    }

    public void setDefaultWidthOffset(int px) {
        control.getState().defaultWidthOffset = px;
    }

    public void setDefaultHeightOffset(int px) {
        control.getState().defaultHeightOffset = px;
    }

    public void setUseUriFragments(boolean useUriFragments) {
        control.getState().useUriFragments = useUriFragments;
    }

    public boolean isUseUriFragments() {
        return control.getState().useUriFragments;
    }
}
