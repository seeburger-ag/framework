/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.select;

import com.vaadin.tests.components.combobox.ComboBoxes2;
import com.vaadin.ui.Select;

public class SelectTest extends ComboBoxes2<Select> {

    @SuppressWarnings("unchecked")
    @Override
    protected Class<Select> getTestClass() {
        return Select.class;
    }

}
