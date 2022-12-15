/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.widget.grid;

import com.google.gwt.user.client.ui.Widget;

/**
 * A callback interface for generating details for a particular row in Grid.
 *
 * @since 7.5.0
 * @author Vaadin Ltd
 */
public interface DetailsGenerator {

    /** A details generator that provides no details */
    public static final DetailsGenerator NULL = new DetailsGenerator() {
        @Override
        public Widget getDetails(int rowIndex) {
            return null;
        }
    };

    /**
     * This method is called for whenever a new details row needs to be
     * generated.
     *
     * @param rowIndex
     *            the index of the row for which to generate details
     * @return the details for the given row, or <code>null</code> to leave the
     *         details empty.
     */
    Widget getDetails(int rowIndex);
}
