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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.vaadin.shared.Connector;

/**
 * Shared state for Grid headers and footers.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public class GridStaticSectionState implements Serializable {

    public static class CellState implements Serializable {
        public String text = "";

        public String html = "";

        public Connector connector = null;

        public GridStaticCellType type = GridStaticCellType.TEXT;

        public String columnId;

        public String styleName = null;
    }

    public static class RowState implements Serializable {
        public List<CellState> cells = new ArrayList<CellState>();

        public boolean defaultRow = false;

        /**
         * Map from column id set to cell state for merged state.
         */
        public Map<Set<String>, CellState> cellGroups = new HashMap<Set<String>, CellState>();

        /**
         * The style name for the row. Null if none.
         */
        public String styleName = null;
    }

    public List<RowState> rows = new ArrayList<RowState>();

    public boolean visible = true;
}
