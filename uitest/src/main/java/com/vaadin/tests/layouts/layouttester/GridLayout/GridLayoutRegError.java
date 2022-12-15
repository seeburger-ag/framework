/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.layouts.layouttester.GridLayout;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.AbstractOrderedLayout;
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
public class GridLayoutRegError extends GridBaseLayoutTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        buildLayout();
        super.setup(request);
    }

    private void buildLayout() {

        layout.addComponent(createLabelsFields(Label.class, true, ""));
        layout.addComponent(createLabelsFields(Button.class, true, ""));
        layout.addComponent(createLabelsFields(TabSheet.class, true, ""));
        layout.addComponent(createLabelsFields(TextField.class, true, ""));

        layout.addComponent(createLabelsFields(ComboBox.class, true, ""));
        layout.addComponent(createLabelsFields(DateField.class, true, ""));
        layout.addComponent(createLabelsFields(NativeSelect.class, true, ""));
        layout.addComponent(createLabelsFields(CheckBox.class, true, ""));

    }

    @Override
    protected void setDefaultForVertical(AbstractOrderedLayout l1,
            AbstractOrderedLayout l2) {
        setLayoutMeasures(l1, l2, "800px", "800px");
    }
}
