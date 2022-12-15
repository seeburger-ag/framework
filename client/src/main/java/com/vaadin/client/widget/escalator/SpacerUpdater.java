/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.widget.escalator;

import com.vaadin.client.widget.escalator.RowContainer.BodyRowContainer;

/**
 * An interface that handles the display of content for spacers.
 * <p>
 * The updater is responsible for making sure all elements are properly
 * constructed and cleaned up.
 *
 * @since 7.5.0
 * @author Vaadin Ltd
 * @see Spacer
 * @see BodyRowContainer
 */
public interface SpacerUpdater {

    /** A spacer updater that does nothing. */
    public static final SpacerUpdater NULL = new SpacerUpdater() {
        @Override
        public void init(Spacer spacer) {
            // NOOP
        }

        @Override
        public void destroy(Spacer spacer) {
            // NOOP
        }
    };

    /**
     * Called whenever a spacer should be initialized with content.
     *
     * @param spacer
     *            the spacer reference that should be initialized
     */
    void init(Spacer spacer);

    /**
     * Called whenever a spacer should be cleaned.
     * <p>
     * The structure to clean up is the same that has been constructed by
     * {@link #init(Spacer)}.
     *
     * @param spacer
     *            the spacer reference that should be destroyed
     */
    void destroy(Spacer spacer);
}
