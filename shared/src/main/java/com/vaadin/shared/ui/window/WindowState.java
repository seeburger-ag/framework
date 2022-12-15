/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.window;

import com.vaadin.shared.Connector;
import com.vaadin.shared.annotations.NoLayout;
import com.vaadin.shared.ui.panel.PanelState;

public class WindowState extends PanelState {
    {
        primaryStyleName = "v-window";
    }

    @NoLayout
    public boolean modal = false;
    @NoLayout
    public boolean resizable = true;
    @NoLayout
    public boolean resizeLazy = false;
    @NoLayout
    public boolean draggable = true;
    @NoLayout
    public boolean centered = false;
    @NoLayout
    public int positionX = -1;
    @NoLayout
    public int positionY = -1;
    public WindowMode windowMode = WindowMode.NORMAL;

    @NoLayout
    public String assistivePrefix = "";
    @NoLayout
    public String assistivePostfix = "";
    @NoLayout
    public Connector[] contentDescription = new Connector[0];
    @NoLayout
    public WindowRole role = WindowRole.DIALOG;
    @NoLayout
    public boolean assistiveTabStop = false;
    @NoLayout
    public String assistiveTabStopTopText = "Top of dialog";
    @NoLayout
    public String assistiveTabStopBottomText = "Bottom of Dialog";
}
