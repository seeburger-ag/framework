/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.orderedlayout;

import java.io.Serializable;
import java.util.HashMap;

import com.vaadin.shared.Connector;
import com.vaadin.shared.ui.AbstractLayoutState;
import com.vaadin.shared.ui.AlignmentInfo;

public class AbstractOrderedLayoutState extends AbstractLayoutState {
    public boolean spacing = false;

    public HashMap<Connector, ChildComponentData> childData = new HashMap<Connector, ChildComponentData>();

    public int marginsBitmask = 0;

    public static class ChildComponentData implements Serializable {

        public int alignmentBitmask = AlignmentInfo.TOP_LEFT.getBitMask();

        public float expandRatio = 0.0f;
    }
}
