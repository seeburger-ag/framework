/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.panel;

import com.vaadin.shared.AbstractComponentState;
import com.vaadin.shared.annotations.NoLayout;

public class PanelState extends AbstractComponentState {
    {
        primaryStyleName = "v-panel";
    }
    @NoLayout
    public int tabIndex;
    @NoLayout
    public int scrollLeft, scrollTop;
}
