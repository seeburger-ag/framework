/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.client.ui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.vaadin.client.SimpleTree;

public class VUnknownComponent extends Composite {

    com.google.gwt.user.client.ui.Label caption = new com.google.gwt.user.client.ui.Label();
    SimpleTree uidlTree;
    protected VerticalPanel panel;

    public VUnknownComponent() {
        panel = new VerticalPanel();
        panel.add(caption);
        initWidget(panel);
        setStyleName("vaadin-unknown");
        caption.setStyleName("vaadin-unknown-caption");
    }

    public void setCaption(String c) {
        caption.getElement().setInnerHTML(c);
    }
}
