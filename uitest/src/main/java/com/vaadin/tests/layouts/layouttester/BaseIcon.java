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
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextField;

/**
 *
 * @since
 * @author Vaadin Ltd
 */
public class BaseIcon extends BaseLayoutTestUI {
    /**
     * @param layoutClass
     */
    public BaseIcon(Class<? extends AbstractLayout> layoutClass) {
        super(layoutClass);
    }

    @Override
    protected void setup(VaadinRequest request) {
        init();
        l1.addComponent(createLabelsFields(TextField.class, true, ""));
        l1.addComponent(createLabelsFields(Label.class, true, ""));
        l1.addComponent(createLabelsFields(Button.class, true, ""));
        l2.addComponent(createLabelsFields(ComboBox.class, true, ""));
        l2.addComponent(createLabelsFields(Link.class, true, ""));
        l2.addComponent(createLabelsFields(TabSheet.class, true, ""));
        super.setup(request);
    }
}
