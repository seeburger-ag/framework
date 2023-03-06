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
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextField;

/**
 *
 * @since
 * @author Vaadin Ltd
 */
public class BaseRegError extends BaseLayoutTestUI {

    public BaseRegError(Class<? extends AbstractLayout> layoutClass) {
        super(layoutClass);
    }

    @Override
    protected void setup(VaadinRequest request) {
        init();
        buildLayout();
        super.setup(request);
    }

    private void buildLayout() {

        l1.addComponent(createLabelsFields(Label.class, true, ""));
        l1.addComponent(createLabelsFields(Button.class, true, ""));
        l1.addComponent(createLabelsFields(TabSheet.class, true, ""));
        l1.addComponent(createLabelsFields(TextField.class, true, ""));

        l2.addComponent(createLabelsFields(ComboBox.class, true, ""));
        l2.addComponent(createLabelsFields(DateField.class, true, ""));
        l2.addComponent(createLabelsFields(NativeSelect.class, true, ""));
        l2.addComponent(createLabelsFields(CheckBox.class, true, ""));

    }
}
