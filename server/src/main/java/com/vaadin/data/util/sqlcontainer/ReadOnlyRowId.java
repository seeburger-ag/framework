/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.data.util.sqlcontainer;

public class ReadOnlyRowId extends RowId {
    private static final long serialVersionUID = -2626764781642012467L;
    private final Integer rowNum;

    public ReadOnlyRowId(int rowNum) {
        super();
        this.rowNum = rowNum;
    }

    @Override
    public int hashCode() {
        return getRowNum();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(ReadOnlyRowId.class.equals(obj.getClass()))) {
            return false;
        }
        return getRowNum() == (((ReadOnlyRowId) obj).getRowNum());
    }

    public int getRowNum() {
        return rowNum;
    }

    @Override
    public String toString() {
        return String.valueOf(getRowNum());
    }
}
