/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.ui;

import com.vaadin.shared.ui.orderedlayout.HorizontalLayoutState;

/**
 * Horizontal layout
 *
 * <code>HorizontalLayout</code> is a component container, which shows the
 * subcomponents in the order of their addition (horizontally).
 *
 * @author Vaadin Ltd.
 * @since 5.3
 */
@SuppressWarnings("serial")
public class HorizontalLayout extends AbstractOrderedLayout {

    /**
     * Constructs an empty HorizontalLayout.
     */
    public HorizontalLayout() {

    }

    /**
     * Constructs a HorizontalLayout with the given components. The components
     * are added in the given order.
     *
     * @see AbstractOrderedLayout#addComponents(Component...)
     *
     * @param children
     *            The components to add.
     */
    public HorizontalLayout(Component... children) {
        this();
        addComponents(children);
    }

    @Override
    protected HorizontalLayoutState getState() {
        return (HorizontalLayoutState) super.getState();
    }

}
