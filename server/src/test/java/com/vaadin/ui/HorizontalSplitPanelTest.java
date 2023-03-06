/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.ui;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.shared.ui.splitpanel.HorizontalSplitPanelState;

public class HorizontalSplitPanelTest {

    @Test
    public void primaryStyleName() {
        Assert.assertEquals(new HorizontalSplitPanelState().primaryStyleName,
                new HorizontalSplitPanel().getPrimaryStyleName());
    }
}
