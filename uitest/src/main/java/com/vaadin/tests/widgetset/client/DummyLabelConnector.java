/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.widgetset.client;

import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.client.ui.VLabel;
import com.vaadin.shared.ui.Connect;
import com.vaadin.tests.widgetset.server.DummyLabel;

/**
 * Dummy connector just to cause {@link LabelState} to be used to test #8683
 *
 * @author Vaadin Ltd
 * @version @VERSION@
 * @since 7.0.0
 */
@Connect(DummyLabel.class)
public class DummyLabelConnector extends AbstractComponentConnector {
    @Override
    public LabelState getState() {
        return (LabelState) super.getState();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);

        getWidget().setText(getState().getText());
    }

    @Override
    public VLabel getWidget() {
        return (VLabel) super.getWidget();
    }
}
