/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.splitpanel;

import com.vaadin.client.ui.VSplitPanelHorizontal;
import com.vaadin.shared.ui.Connect;
import com.vaadin.shared.ui.Connect.LoadStyle;
import com.vaadin.shared.ui.splitpanel.HorizontalSplitPanelState;
import com.vaadin.ui.HorizontalSplitPanel;

@Connect(value = HorizontalSplitPanel.class, loadStyle = LoadStyle.EAGER)
public class HorizontalSplitPanelConnector extends AbstractSplitPanelConnector {

    @Override
    public VSplitPanelHorizontal getWidget() {
        return (VSplitPanelHorizontal) super.getWidget();
    }

    @Override
    public HorizontalSplitPanelState getState() {
        return (HorizontalSplitPanelState) super.getState();
    }

}
