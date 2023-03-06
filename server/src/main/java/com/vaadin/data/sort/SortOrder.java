/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.data.sort;

import java.io.Serializable;

import com.vaadin.shared.data.sort.SortDirection;

/**
 * Sort order descriptor. Links together a {@link SortDirection} value and a
 * Vaadin container property ID.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public class SortOrder implements Serializable {

    private final Object propertyId;
    private final SortDirection direction;

    /**
     * Create a SortOrder object. Both arguments must be non-null.
     *
     * @param propertyId
     *            id of the data source property to sort by
     * @param direction
     *            value indicating whether the property id should be sorted in
     *            ascending or descending order
     */
    public SortOrder(Object propertyId, SortDirection direction) {
        if (propertyId == null) {
            throw new IllegalArgumentException("Property ID can not be null!");
        }
        if (direction == null) {
            throw new IllegalArgumentException(
                    "Direction value can not be null!");
        }
        this.propertyId = propertyId;
        this.direction = direction;
    }

    /**
     * Returns the property ID.
     *
     * @return a property ID
     */
    public Object getPropertyId() {
        return propertyId;
    }

    /**
     * Returns the {@link SortDirection} value.
     *
     * @return a sort direction value
     */
    public SortDirection getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return propertyId + " " + direction;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + direction.hashCode();
        result = prime * result + propertyId.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        }

        SortOrder other = (SortOrder) obj;
        if (direction != other.direction) {
            return false;
        } else if (!propertyId.equals(other.propertyId)) {
            return false;
        }
        return true;
    }

}
