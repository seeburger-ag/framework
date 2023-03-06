/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.grid;

import java.io.Serializable;

import com.vaadin.shared.Connector;

/**
 * Column state DTO for transferring column properties from the server to the
 * client
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public class GridColumnState implements Serializable {

    /**
     * Id used by grid connector to map server side column with client side
     * column
     */
    public String id;

    /**
     * Column width in pixels. Default column width is
     * {@value GridConstants#DEFAULT_COLUMN_WIDTH_PX}.
     */
    public double width = GridConstants.DEFAULT_COLUMN_WIDTH_PX;

    /**
     * The connector for the renderer used to render the cells in this column.
     */
    public Connector rendererConnector;

    /**
     * Whether the values in this column are editable when the editor interface
     * is active.
     */
    public boolean editable = true;

    /**
     * The connector for the field used to edit cells in this column when the
     * editor interface is active.
     */
    public Connector editorConnector;

    /**
     * Whether this column is sortable by the user
     */
    public boolean sortable = false;

    /** How much of the remaining space this column will reserve. */
    public int expandRatio = GridConstants.DEFAULT_EXPAND_RATIO;

    /**
     * The maximum expansion width of this column. -1 for "no maximum". If
     * maxWidth is less than the calculated width, maxWidth is ignored.
     */
    public double maxWidth = GridConstants.DEFAULT_MAX_WIDTH;

    /**
     * The minimum expansion width of this column. -1 for "no minimum". If
     * minWidth is less than the calculated width, minWidth will win.
     */
    public double minWidth = GridConstants.DEFAULT_MIN_WIDTH;

    /** Whether this column is currently hidden. */
    public boolean hidden = false;

    /** Whether the column can be hidden by the user. */
    public boolean hidable = false;

    /** The caption for the column hiding toggle. */
    public String hidingToggleCaption;

    /** Column header caption */
    public String headerCaption;

    /** Whether this column is resizable by the user. */
    public boolean resizable = true;
}
