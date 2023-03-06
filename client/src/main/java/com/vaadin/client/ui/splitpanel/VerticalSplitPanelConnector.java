/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.splitpanel;

import com.vaadin.client.ui.VSplitPanelVertical;
import com.vaadin.shared.ui.Connect;
import com.vaadin.shared.ui.Connect.LoadStyle;
import com.vaadin.shared.ui.splitpanel.VerticalSplitPanelState;
import com.vaadin.ui.VerticalSplitPanel;

@Connect(value = VerticalSplitPanel.class, loadStyle = LoadStyle.EAGER)
public class VerticalSplitPanelConnector extends AbstractSplitPanelConnector {

    @Override
    public VSplitPanelVertical getWidget() {
        return (VSplitPanelVertical) super.getWidget();
    }

    @Override
    public VerticalSplitPanelState getState() {
        return (VerticalSplitPanelState) super.getState();
    }

}
