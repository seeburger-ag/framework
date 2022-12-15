/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.data.util.sqlcontainer;

import java.io.Serializable;
import java.util.Arrays;

/**
 * RowId represents identifiers of a single database result set row.
 *
 * The data structure of a RowId is an Object array which contains the values of
 * the primary key columns of the identified row. This allows easy equals()
 * -comparison of RowItems.
 */
public class RowId implements Serializable {
    private static final long serialVersionUID = -3161778404698901258L;
    protected Object[] id;

    /**
     * Prevent instantiation without required parameters.
     */
    protected RowId() {
    }

    public RowId(Object... id) {
        if (id == null) {
            throw new IllegalArgumentException(
                    "id parameter must not be null!");
        }
        this.id = id;
    }

    public Object[] getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(getId());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(RowId.class.equals(obj.getClass()))) {
            return false;
        }
        return Arrays.equals(getId(), ((RowId) obj).getId());
    }

    @Override
    public String toString() {
        if (getId() == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for (Object id : getId()) {
            builder.append(id);
            builder.append('/');
        }
        if (builder.length() > 0) {
            return builder.substring(0, builder.length() - 1);
        }
        return builder.toString();
    }
}
