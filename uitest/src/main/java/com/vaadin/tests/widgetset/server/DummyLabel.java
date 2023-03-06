/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.widgetset.server;

import com.vaadin.tests.widgetset.client.LabelState;
import com.vaadin.ui.AbstractComponent;

/**
 * Dummy component to cause {@link LabelState} to be used to test #8683
 *
 * @author Vaadin Ltd
 * @version @VERSION@
 * @since 7.0.0
 */
public class DummyLabel extends AbstractComponent {
    public DummyLabel(String text) {
        getState().setText(text);
    }

    @Override
    public LabelState getState() {
        return (LabelState) super.getState();
    }
}
