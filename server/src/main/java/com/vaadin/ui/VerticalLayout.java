/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.ui;

import com.vaadin.shared.ui.orderedlayout.VerticalLayoutState;

/**
 * Vertical layout
 *
 * <code>VerticalLayout</code> is a component container, which shows the
 * subcomponents in the order of their addition (vertically). A vertical layout
 * is by default 100% wide.
 *
 * @author Vaadin Ltd.
 * @since 5.3
 */
@SuppressWarnings("serial")
public class VerticalLayout extends AbstractOrderedLayout {

    /**
     * Constructs an empty VerticalLayout.
     */
    public VerticalLayout() {
        setWidth("100%");
    }

    /**
     * Constructs a VerticalLayout with the given components. The components are
     * added in the given order.
     *
     * @see AbstractOrderedLayout#addComponents(Component...)
     *
     * @param children
     *            The components to add.
     */
    public VerticalLayout(Component... children) {
        this();
        addComponents(children);
    }

    @Override
    protected VerticalLayoutState getState() {
        return (VerticalLayoutState) super.getState();
    }
}
