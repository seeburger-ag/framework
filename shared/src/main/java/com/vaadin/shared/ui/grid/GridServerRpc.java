/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.grid;

import java.util.List;

import com.vaadin.shared.MouseEventDetails;
import com.vaadin.shared.communication.ServerRpc;
import com.vaadin.shared.data.sort.SortDirection;
import com.vaadin.shared.ui.grid.GridConstants.Section;

/**
 * Client-to-server RPC interface for the Grid component
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public interface GridServerRpc extends ServerRpc {

    void sort(String[] columnIds, SortDirection[] directions,
            boolean userOriginated);

    /**
     * Informs the server that an item has been clicked in Grid.
     *
     * @param rowKey
     *            a key identifying the clicked item
     * @param columnId
     *            column id identifying the clicked property
     * @param details
     *            mouse event details
     */
    void itemClick(String rowKey, String columnId, MouseEventDetails details);

    /**
     * Informs the server that a context click has happened inside of Grid.
     *
     * @since 7.6
     * @param rowIndex
     *            index of clicked row in Grid section
     * @param rowKey
     *            a key identifying the clicked item
     * @param columnId
     *            column id identifying the clicked property
     * @param section
     *            grid section (header, footer, body)
     * @param details
     *            mouse event details
     */
    void contextClick(int rowIndex, String rowKey, String columnId,
            Section section, MouseEventDetails details);

    /**
     * Informs the server that the columns of the Grid have been reordered.
     *
     * @since 7.5.0
     * @param newColumnOrder
     *            a list of column ids in the new order
     * @param oldColumnOrder
     *            a list of column ids in order before the change
     */
    void columnsReordered(List<String> newColumnOrder,
            List<String> oldColumnOrder);

    /**
     * Informs the server that a column's visibility has been changed.
     *
     * @since 7.5.0
     * @param id
     *            the id of the column
     * @param hidden
     *            <code>true</code> if hidden, <code>false</code> if unhidden
     * @param userOriginated
     *            <code>true</code> if triggered by user, <code>false</code> if
     *            by code
     */
    void columnVisibilityChanged(String id, boolean hidden,
            boolean userOriginated);

    /**
     * Informs the server that a column has been resized by the user.
     *
     * @since 7.6
     * @param id
     *            the id of the column
     * @param pixels
     *            the new width of the column in pixels
     */
    void columnResized(String id, double pixels);
}
