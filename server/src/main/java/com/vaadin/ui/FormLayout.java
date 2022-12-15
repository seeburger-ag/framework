/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.ui;

import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.shared.ui.orderedlayout.FormLayoutState;

/**
 * FormLayout is used by {@link Form} to layout fields. It may also be used
 * separately without {@link Form}.
 *
 * FormLayout is a close relative of {@link VerticalLayout}, but in FormLayout
 * captions are rendered to the left of their respective components. Required
 * and validation indicators are shown between the captions and the fields.
 *
 * FormLayout by default has component spacing on. Also margin top and margin
 * bottom are by default on.
 *
 */
public class FormLayout extends AbstractOrderedLayout {

    public FormLayout() {
        super();
        setSpacing(true);
        setMargin(new MarginInfo(true, false));
        setWidth(100, UNITS_PERCENTAGE);
    }

    /**
     * Constructs a FormLayout and adds the given components to it.
     *
     * @see AbstractOrderedLayout#addComponents(Component...)
     *
     * @param children
     *            Components to add to the FormLayout
     */
    public FormLayout(Component... children) {
        this();
        addComponents(children);
    }

    /**
     * @deprecated This method currently has no effect as expand ratios are not
     *             implemented in FormLayout
     */
    @Override
    @Deprecated
    public void setExpandRatio(Component component, float ratio) {
        super.setExpandRatio(component, ratio);
    }

    /**
     * @deprecated This method currently has no effect as expand ratios are not
     *             implemented in FormLayout
     */
    @Override
    @Deprecated
    public float getExpandRatio(Component component) {
        return super.getExpandRatio(component);
    }

    @Override
    protected FormLayoutState getState() {
        return (FormLayoutState) super.getState();
    }
}
