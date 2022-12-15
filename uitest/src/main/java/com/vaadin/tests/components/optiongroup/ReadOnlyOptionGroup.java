/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.optiongroup;

import java.util.Collections;

import com.vaadin.data.Property;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.OptionGroup;

/**
 * Test UI for unset read-only flag of Option group with new items allowed.
 *
 * @author Vaadin Ltd
 */
public class ReadOnlyOptionGroup extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        final OptionGroup optionGroup = new OptionGroup("test field",
                Collections.singletonList("Option"));
        optionGroup.setNewItemsAllowed(true);

        final CheckBox readOnlyCheckbox = new CheckBox("read-only");
        readOnlyCheckbox.setImmediate(true);
        readOnlyCheckbox
                .addValueChangeListener(new Property.ValueChangeListener() {
                    @Override
                    public void valueChange(Property.ValueChangeEvent event) {
                        optionGroup.setReadOnly(readOnlyCheckbox.getValue());
                    }
                });
        readOnlyCheckbox.setValue(Boolean.TRUE);

        addComponent(optionGroup);
        addComponent(readOnlyCheckbox);
    }

    @Override
    protected String getTestDescription() {
        return "Unset read-only state for Option group should not throw an exception";
    }

    @Override
    protected Integer getTicketNumber() {
        return 11772;
    }

}
