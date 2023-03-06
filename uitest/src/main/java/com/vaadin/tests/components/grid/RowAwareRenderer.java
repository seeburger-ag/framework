/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid;

import com.vaadin.tests.widgetset.client.grid.RowAwareRendererConnector.RowAwareRendererRpc;
import com.vaadin.ui.Grid.AbstractRenderer;
import com.vaadin.ui.Label;

public class RowAwareRenderer extends AbstractRenderer<Void> {
    public RowAwareRenderer(final Label debugLabel) {
        super(Void.class, "");
        registerRpc(new RowAwareRendererRpc() {
            @Override
            public void clicky(String key) {
                Object itemId = getItemId(key);
                debugLabel.setValue("key: " + key + ", itemId: " + itemId);
            }
        });
    }
}
