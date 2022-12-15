/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests;

import com.vaadin.ui.Label;
import com.vaadin.ui.LegacyWindow;
import com.vaadin.ui.VerticalSplitPanel;

public class TestSplitPanel extends com.vaadin.server.LegacyApplication {

    VerticalSplitPanel verticalSplit = new VerticalSplitPanel();

    @Override
    public void init() {
        final LegacyWindow mainWindow = new LegacyWindow("Feature Browser");
        setMainWindow(mainWindow);

        verticalSplit.setFirstComponent(new Label("vertical first"));
        verticalSplit.setSecondComponent(new Label("vertical second"));

        mainWindow.setContent(verticalSplit);

    }

}
