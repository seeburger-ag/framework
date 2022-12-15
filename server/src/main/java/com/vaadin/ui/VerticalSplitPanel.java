/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.ui;

import com.vaadin.shared.ui.splitpanel.VerticalSplitPanelState;

/**
 * A vertical split panel contains two components and lays them vertically. The
 * first component is above the second component.
 *
 * <pre>
 *      +--------------------------+
 *      |                          |
 *      |  The first component     |
 *      |                          |
 *      +==========================+  <-- splitter
 *      |                          |
 *      |  The second component    |
 *      |                          |
 *      +--------------------------+
 * </pre>
 *
 */
public class VerticalSplitPanel extends AbstractSplitPanel {

    public VerticalSplitPanel() {
        super();
        setSizeFull();
    }

    /**
     * Creates a horizontal split panel containing the given components
     *
     * @param firstComponent
     *            The component to be placed above the splitter
     * @param secondComponent
     *            The component to be placed below of the splitter
     */
    public VerticalSplitPanel(Component firstComponent,
            Component secondComponent) {
        this();
        setFirstComponent(firstComponent);
        setSecondComponent(secondComponent);
    }

    @Override
    protected VerticalSplitPanelState getState() {
        return (VerticalSplitPanelState) super.getState();
    }
}
