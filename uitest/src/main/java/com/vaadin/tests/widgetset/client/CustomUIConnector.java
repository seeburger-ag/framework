/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.widgetset.client;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.SpanElement;
import com.vaadin.client.ui.ui.UIConnector;
import com.vaadin.shared.ui.Connect;
import com.vaadin.ui.UI;

@Connect(UI.class)
public class CustomUIConnector extends UIConnector {
    @Override
    protected void init() {
        super.init();
        registerRpc(CustomUIConnectorRpc.class, new CustomUIConnectorRpc() {
            @Override
            public void test() {
                SpanElement span = Document.get().createSpanElement();
                span.setInnerText("This is the "
                        + CustomUIConnector.this.getClass().getSimpleName());
                Document.get().getBody().insertFirst(span);
            }
        });
    }
}
