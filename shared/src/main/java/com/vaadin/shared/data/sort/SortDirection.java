/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.data.sort;

import java.io.Serializable;

/**
 * Describes sorting direction.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public enum SortDirection implements Serializable {

    /**
     * Ascending (e.g. A-Z, 1..9) sort order
     */
    ASCENDING {
        @Override
        public SortDirection getOpposite() {
            return DESCENDING;
        }
    },

    /**
     * Descending (e.g. Z-A, 9..1) sort order
     */
    DESCENDING {
        @Override
        public SortDirection getOpposite() {
            return ASCENDING;
        }
    };

    /**
     * Get the sort direction that is the direct opposite to this one.
     *
     * @return a sort direction value
     */
    public abstract SortDirection getOpposite();
}
