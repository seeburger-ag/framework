/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui;

import com.vaadin.client.StyleConstants;
import com.vaadin.client.ui.orderedlayout.VAbstractOrderedLayout;

/**
 * Represents a layout where the children is ordered vertically
 */
public class VVerticalLayout extends VAbstractOrderedLayout {

    public static final String CLASSNAME = "v-verticallayout";

    /**
     * Default constructor
     */
    public VVerticalLayout() {
        super(true);
        setStyleName(CLASSNAME);
    }

    @Override
    public void setStyleName(String style) {
        super.setStyleName(style);
        addStyleName(StyleConstants.UI_LAYOUT);
        addStyleName("v-vertical");
    }
}
