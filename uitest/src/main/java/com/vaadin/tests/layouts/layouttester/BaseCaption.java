/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.layouts.layouttester;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.AbstractLayout;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.TabSheet;

/**
 *
 * @since
 * @author Vaadin Ltd
 */
public class BaseCaption extends BaseLayoutTestUI {

    /**
     * @param layoutClass
     */
    public BaseCaption(Class<? extends AbstractLayout> layoutClass) {
        super(layoutClass);
    }

    @Override
    protected void setup(VaadinRequest request) {
        init();
        l1.addComponent(createLabelsFields(ComboBox.class, true, ""));
        l2.addComponent(createLabelsFields(TabSheet.class, false, ""));
        super.setup(request);
    }
}
