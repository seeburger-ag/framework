/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.ui;

import java.util.Collection;

import com.vaadin.data.Container;
import com.vaadin.server.PaintException;
import com.vaadin.server.PaintTarget;

/**
 * This is a simple list select without, for instance, support for new items,
 * lazyloading, and other advanced features.
 */
@SuppressWarnings("serial")
public class ListSelect extends AbstractSelect {

    private int columns = 0;
    private int rows = 0;

    public ListSelect() {
        super();
    }

    public ListSelect(String caption, Collection<?> options) {
        super(caption, options);
    }

    public ListSelect(String caption, Container dataSource) {
        super(caption, dataSource);
    }

    public ListSelect(String caption) {
        super(caption);
    }

    /**
     * Sets the width of the component so that it can display approximately the
     * given number of letters.
     * <p>
     * Calling {@code setColumns(10);} is equivalent to calling
     * {@code setWidth("10em");}
     * </p>
     *
     * @deprecated As of 7.0. "Columns" does not reflect the exact number of
     *             characters that will be displayed. It is better to use
     *             setWidth together with "em" to control the width of the
     *             field.
     * @param columns
     *            the number of columns to set.
     */
    @Deprecated
    public void setColumns(int columns) {
        if (columns < 0) {
            columns = 0;
        }
        if (this.columns != columns) {
            this.columns = columns;
            markAsDirty();
        }
    }

    /**
     * Gets the number of columns for the component.
     *
     * @see #setColumns(int)
     * @deprecated As of 7.0. "Columns" does not reflect the exact number of
     *             characters that will be displayed. It is better to use
     *             setWidth together with "em" to control the width of the
     *             field.
     */
    @Deprecated
    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    /**
     * Sets the number of rows in the editor. If the number of rows is set 0,
     * the actual number of displayed rows is determined implicitly by the
     * adapter.
     *
     * @param rows
     *            the number of rows to set.
     */
    public void setRows(int rows) {
        if (rows < 0) {
            rows = 0;
        }
        if (this.rows != rows) {
            this.rows = rows;
            markAsDirty();
        }
    }

    @Override
    public void paintContent(PaintTarget target) throws PaintException {
        target.addAttribute("type", "list");
        // Adds the number of columns
        if (columns != 0) {
            target.addAttribute("cols", columns);
        }
        // Adds the number of rows
        if (rows != 0) {
            target.addAttribute("rows", rows);
        }
        super.paintContent(target);
    }
}
