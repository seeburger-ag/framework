/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.design.nested.customlayouts;

import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;

/**
 * @author Vaadin Ltd
 */
public class CustomHorizontalSplitPanel extends HorizontalSplitPanel {
    public CustomHorizontalSplitPanel() {
        addComponent(new Label());
    }
}
