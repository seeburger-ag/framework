/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.widget.grid;

import com.google.gwt.dom.client.TableCellElement;
import com.vaadin.client.widgets.Grid;

/**
 * A data class which contains information which identifies a cell in a
 * {@link Grid}.
 * <p>
 * Since this class follows the <code>Flyweight</code>-pattern any instance of
 * this object is subject to change without the user knowing it and so should
 * not be stored anywhere outside of the method providing these instances.
 *
 * @author Vaadin Ltd
 * @param <T>
 *            the type of the row object containing this cell
 * @since 7.4
 */
public class CellReference<T> {

    private int columnIndexDOM;
    private int columnIndex;
    private Grid.Column<?, T> column;
    private final RowReference<T> rowReference;

    public CellReference(RowReference<T> rowReference) {
        this.rowReference = rowReference;
    }

    /**
     * Sets the identifying information for this cell.
     * <p>
     * The difference between {@link #columnIndexDOM} and {@link #columnIndex}
     * comes from hidden columns.
     *
     * @param columnIndexDOM
     *            the index of the column in the DOM
     * @param columnIndex
     *            the index of the column
     * @param column
     *            the column object
     */
    public void set(int columnIndexDOM, int columnIndex,
            Grid.Column<?, T> column) {
        this.columnIndexDOM = columnIndexDOM;
        this.columnIndex = columnIndex;
        this.column = column;
    }

    /**
     * Gets the grid that contains the referenced cell.
     *
     * @return the grid that contains referenced cell
     */
    public Grid<T> getGrid() {
        return rowReference.getGrid();
    }

    /**
     * Gets the row index of the row.
     *
     * @return the index of the row
     */
    public int getRowIndex() {
        return rowReference.getRowIndex();
    }

    /**
     * Gets the row data object.
     *
     * @return the row object
     */
    public T getRow() {
        return rowReference.getRow();
    }

    /**
     * Gets the index of the column.
     * <p>
     * <em>NOTE:</em> The index includes hidden columns in the count, unlike
     * {@link #getColumnIndexDOM()}.
     *
     * @return the index of the column
     */
    public int getColumnIndex() {
        return columnIndex;
    }

    /**
     * Gets the index of the cell in the DOM. The difference to
     * {@link #getColumnIndex()} is caused by hidden columns.
     *
     * @since 7.5.0
     * @return the index of the column in the DOM
     */
    public int getColumnIndexDOM() {
        return columnIndexDOM;
    }

    /**
     * Gets the column objects.
     *
     * @return the column object
     */
    public Grid.Column<?, T> getColumn() {
        return column;
    }

    /**
     * Gets the value of the cell.
     *
     * @return the value of the cell
     */
    public Object getValue() {
        return getColumn().getValue(getRow());
    }

    /**
     * Get the element of the cell.
     *
     * @return the element of the cell
     */
    public TableCellElement getElement() {
        return rowReference.getElement().getCells().getItem(columnIndexDOM);
    }

    /**
     * Gets the RowReference for this CellReference.
     *
     * @return the row reference
     */
    protected RowReference<T> getRowReference() {
        return rowReference;
    }

}