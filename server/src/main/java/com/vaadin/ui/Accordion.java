/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.ui;

import com.vaadin.shared.ui.accordion.AccordionState;

/**
 * An accordion is a component similar to a {@link TabSheet}, but with a
 * vertical orientation and the selected component presented between tabs.
 *
 * Closable tabs are not supported by the accordion.
 *
 * The {@link Accordion} can be styled with the .v-accordion, .v-accordion-item,
 * .v-accordion-item-first and .v-accordion-item-caption styles.
 *
 * @see TabSheet
 */
public class Accordion extends TabSheet {
    /**
     * Creates an empty accordion.
     */
    public Accordion() {
        super();
    }

    /**
     * Constructs a new accordion containing the given components.
     *
     * @param components
     *            The components to add to the accordion. Each component will be
     *            added to a separate tab.
     */
    public Accordion(Component... components) {
        this();
        addComponents(components);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.ui.TabSheet#getState()
     */
    @Override
    protected AccordionState getState() {
        return (AccordionState) super.getState();
    }

}
