/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.widgetset.client;

import com.vaadin.shared.ui.Connect;
import com.vaadin.tests.widgetset.server.ReplaceComponent;

@Connect(value = ReplaceComponent.class)
public class IntermediateReplaceConnector extends ReplacedConnector {
    @Override
    protected void init() {
        super.init();
        getWidget().setHTML(IntermediateReplaceConnector.class.getName()
                + ", should not be used");
    }
}
