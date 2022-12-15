/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.ui;

import com.vaadin.shared.ui.splitpanel.HorizontalSplitPanelState;

/**
 * A horizontal split panel contains two components and lays them horizontally.
 * The first component is on the left side.
 *
 * <pre>
 *
 *      +---------------------++----------------------+
 *      |                     ||                      |
 *      | The first component || The second component |
 *      |                     ||                      |
 *      +---------------------++----------------------+
 *                              
 *                            ^
 *                            |
 *                      the splitter
 *
 * </pre>
 *
 * @author Vaadin Ltd.
 * @since 6.5
 */
public class HorizontalSplitPanel extends AbstractSplitPanel {
    /**
     * Creates an empty horizontal split panel
     */
    public HorizontalSplitPanel() {
        super();
        setSizeFull();
    }

    /**
     * Creates a horizontal split panel containing the given components
     *
     * @param firstComponent
     *            The component to be placed to the left of the splitter
     * @param secondComponent
     *            The component to be placed to the right of the splitter
     */
    public HorizontalSplitPanel(Component firstComponent,
            Component secondComponent) {
        this();
        setFirstComponent(firstComponent);
        setSecondComponent(secondComponent);
    }

    @Override
    protected HorizontalSplitPanelState getState() {
        return (HorizontalSplitPanelState) super.getState();
    }
}
