/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.widget.escalator;

import com.google.gwt.dom.client.TableCellElement;

/**
 * Describes a cell
 * <p>
 * It's a representation of the element in a grid cell, and its row and column
 * indices.
 * <p>
 * Unlike the {@link FlyweightRow}, an instance of {@link Cell} can be stored in
 * a field.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public class Cell {

    private final int row;

    private final int column;

    private final TableCellElement element;

    /**
     * Constructs a new {@link Cell}.
     *
     * @param row
     *            The index of the row
     * @param column
     *            The index of the column
     * @param element
     *            The cell element
     */
    public Cell(int row, int column, TableCellElement element) {
        super();
        this.row = row;
        this.column = column;
        this.element = element;
    }

    /**
     * Returns the index of the row the cell resides in.
     *
     * @return the row index
     *
     */
    public int getRow() {
        return row;
    }

    /**
     * Returns the index of the column the cell resides in.
     *
     * @return the column index
     */
    public int getColumn() {
        return column;
    }

    /**
     * Returns the element of the cell.
     *
     * @return the cell element
     */
    public TableCellElement getElement() {
        return element;
    }

}
