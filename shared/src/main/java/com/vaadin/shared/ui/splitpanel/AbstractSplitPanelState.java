/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.splitpanel;

import java.io.Serializable;

import com.vaadin.shared.AbstractComponentState;
import com.vaadin.shared.Connector;

public class AbstractSplitPanelState extends AbstractComponentState {
    public Connector firstChild = null;
    public Connector secondChild = null;
    public SplitterState splitterState = new SplitterState();

    public static class SplitterState implements Serializable {
        public float position;
        public String positionUnit;
        public float minPosition;
        public String minPositionUnit;
        public float maxPosition;
        public String maxPositionUnit;
        public boolean positionReversed = false;
        public boolean locked = false;
    }
}
