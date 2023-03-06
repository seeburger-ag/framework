/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.optiongroup;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUIWithLog;
import com.vaadin.ui.OptionGroup;

public class OptionGroupDisabled extends AbstractTestUIWithLog {

    @Override
    protected void setup(VaadinRequest request) {
        OptionGroup optionGroup = new OptionGroup();
        optionGroup.setEnabled(false);
        optionGroup.setImmediate(true);
        optionGroup.setMultiSelect(true);
        optionGroup.addItem("test 1");
        optionGroup.addItem("test 2");
        optionGroup.addItem("test 3");

        addComponent(optionGroup);
    }

}
