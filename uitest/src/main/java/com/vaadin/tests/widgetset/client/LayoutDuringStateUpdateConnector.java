/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.widgetset.client;

import com.google.gwt.user.client.ui.Label;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.client.ui.PostLayoutListener;
import com.vaadin.shared.ui.Connect;
import com.vaadin.tests.widgetset.server.LayoutDuringStateUpdateComponent;

@Connect(LayoutDuringStateUpdateComponent.class)
public class LayoutDuringStateUpdateConnector extends AbstractComponentConnector
        implements PostLayoutListener {
    private int layoutCount = 0;

    @Override
    protected void init() {
        super.init();
        updateLabelText();
    }

    @Override
    public Label getWidget() {
        return (Label) super.getWidget();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);

        try {
            getLayoutManager().layoutNow();
        } catch (AssertionError e) {
            // Ignore
        }
    }

    private void updateLabelText() {
        getWidget().setText("Layout phase count: " + layoutCount);
    }

    @Override
    public void postLayout() {
        layoutCount++;
        updateLabelText();
    }

}
