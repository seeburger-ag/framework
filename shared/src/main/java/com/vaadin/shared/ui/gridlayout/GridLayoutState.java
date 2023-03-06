/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.gridlayout;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.vaadin.shared.Connector;
import com.vaadin.shared.ui.AbstractLayoutState;
import com.vaadin.shared.ui.AlignmentInfo;

public class GridLayoutState extends AbstractLayoutState {
    public static AlignmentInfo ALIGNMENT_DEFAULT = AlignmentInfo.TOP_LEFT;

    {
        primaryStyleName = "v-gridlayout";
    }
    public boolean spacing = false;
    public int rows = 0;
    public int columns = 0;
    public int marginsBitmask = 0;
    // Set of indexes of implicitly Ratios rows and columns
    public Set<Integer> explicitRowRatios = new HashSet<Integer>();;
    public Set<Integer> explicitColRatios = new HashSet<Integer>();
    public Map<Connector, ChildComponentData> childData = new HashMap<Connector, GridLayoutState.ChildComponentData>();
    public boolean hideEmptyRowsAndColumns = false;
    public float[] rowExpand;
    public float[] colExpand;

    public static class ChildComponentData implements Serializable {
        public int column1;
        public int row1;
        public int column2;
        public int row2;
        public int alignment = ALIGNMENT_DEFAULT.getBitMask();

    }
}
