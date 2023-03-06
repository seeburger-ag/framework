/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.layout;

import com.google.gwt.dom.client.Element;
import com.vaadin.client.LayoutManager;

public class ElementResizeEvent {
    private final Element element;
    private final LayoutManager layoutManager;

    public ElementResizeEvent(LayoutManager layoutManager, Element element) {
        this.layoutManager = layoutManager;
        this.element = element;
    }

    public Element getElement() {
        return element;
    }

    public LayoutManager getLayoutManager() {
        return layoutManager;
    }
}
