/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.data.util.sqlcontainer;

import com.vaadin.data.util.sqlcontainer.query.TableQuery;

/**
 * An OptimisticLockException is thrown when trying to update or delete a row
 * that has been changed since last read from the database.
 *
 * OptimisticLockException is a runtime exception because optimistic locking is
 * turned off by default, and as such will never be thrown in a default
 * configuration. In order to turn on optimistic locking, you need to specify
 * the version column in your TableQuery instance.
 *
 * @see TableQuery#setVersionColumn(String)
 *
 * @author Jonatan Kronqvist / Vaadin Ltd
 */
public class OptimisticLockException extends RuntimeException {

    private final RowId rowId;

    public OptimisticLockException(RowId rowId) {
        super();
        this.rowId = rowId;
    }

    public OptimisticLockException(String msg, RowId rowId) {
        super(msg);
        this.rowId = rowId;
    }

    public RowId getRowId() {
        return rowId;
    }
}
