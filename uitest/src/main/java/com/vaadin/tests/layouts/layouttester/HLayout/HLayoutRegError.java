/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.layouts.layouttester.HLayout;

import com.vaadin.tests.layouts.layouttester.BaseRegError;
import com.vaadin.ui.AbstractOrderedLayout;
import com.vaadin.ui.HorizontalLayout;

/**
 *
 * @since
 * @author Vaadin Ltd
 */

public class HLayoutRegError extends BaseRegError {

    /**
     * @param layoutClass
     */
    public HLayoutRegError() {
        super(HorizontalLayout.class);
    }

    @Override
    protected void setLayoutMeasures(AbstractOrderedLayout l1,
            AbstractOrderedLayout l2, String w, String h) {
        super.setLayoutMeasures(l1, l2, "3200px", "200px");
    }
}
