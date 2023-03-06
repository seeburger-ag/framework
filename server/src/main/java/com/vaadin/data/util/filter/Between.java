/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.data.util.filter;

import java.util.Arrays;

import com.vaadin.data.Container.Filter;
import com.vaadin.data.Item;
import com.vaadin.shared.util.SharedUtil;

public class Between implements Filter {

    private final Object propertyId;
    private final Comparable<?> startValue;
    private final Comparable<?> endValue;

    public Between(Object propertyId, Comparable<?> startValue,
            Comparable<?> endValue) {
        this.propertyId = propertyId;
        this.startValue = startValue;
        this.endValue = endValue;
    }

    public Object getPropertyId() {
        return propertyId;
    }

    public Comparable<?> getStartValue() {
        return startValue;
    }

    public Comparable<?> getEndValue() {
        return endValue;
    }

    @Override
    public boolean passesFilter(Object itemId, Item item)
            throws UnsupportedOperationException {
        Object value = item.getItemProperty(getPropertyId()).getValue();
        if (value instanceof Comparable) {
            Comparable comparable = (Comparable) value;
            return isAfterStartValue(comparable)
                    && isBeforeEndValue(comparable);
        } else if (value == null) {
            return getStartValue() == null && getEndValue() == null;
        }
        return false;
    }

    @Override
    public boolean appliesToProperty(Object propertyId) {
        return getPropertyId() != null && getPropertyId().equals(propertyId);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(new Object[] { getPropertyId(), getStartValue(),
                getEndValue() });
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        // Only objects of the same class can be equal
        if (!getClass().equals(obj.getClass())) {
            return false;
        }
        final Between o = (Between) obj;

        // Checks the properties one by one
        boolean propertyIdEqual = SharedUtil.equals(getPropertyId(),
                o.getPropertyId());
        boolean startValueEqual = SharedUtil.equals(getStartValue(),
                o.getStartValue());
        boolean endValueEqual = SharedUtil.equals(getEndValue(),
                o.getEndValue());
        return propertyIdEqual && startValueEqual && endValueEqual;

    }

    private boolean isAfterStartValue(Comparable comparable) {
        return getStartValue() == null
                || comparable.compareTo(getStartValue()) >= 0;
    }

    private boolean isBeforeEndValue(Comparable comparable) {
        return getEndValue() == null
                || comparable.compareTo(getEndValue()) <= 0;
    }
}
