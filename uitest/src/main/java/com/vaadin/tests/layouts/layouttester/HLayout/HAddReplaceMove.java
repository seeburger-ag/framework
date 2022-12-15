/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.layouts.layouttester.HLayout;

import com.vaadin.tests.layouts.layouttester.BaseAddReplaceMove;
import com.vaadin.ui.AbstractOrderedLayout;
import com.vaadin.ui.HorizontalLayout;

public class HAddReplaceMove extends BaseAddReplaceMove {

    /**
     * @param layoutClass
     */
    public HAddReplaceMove() {
        super(HorizontalLayout.class);
    }

    @Override
    protected void setLayoutMeasures(AbstractOrderedLayout l1,
            AbstractOrderedLayout l2, String w, String h) {
        super.setLayoutMeasures(l1, l2, "1200px", h);
    }

}
