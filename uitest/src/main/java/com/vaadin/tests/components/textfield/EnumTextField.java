/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.textfield;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUIWithLog;
import com.vaadin.ui.TextField;

public class EnumTextField extends AbstractTestUIWithLog {

    public enum MyEnum {
        FIRST_VALUE, VALUE, THE_LAST_VALUE;
    }

    @Override
    protected void setup(VaadinRequest request) {
        final TextField tf = new TextField();
        tf.setNullRepresentation("");
        tf.addValueChangeListener(new ValueChangeListener() {

            @Override
            public void valueChange(ValueChangeEvent event) {
                if (tf.isValid()) {
                    log(tf.getValue() + " (valid)");
                } else {
                    log(tf.getValue() + " (INVALID)");
                }
            }
        });

        tf.setPropertyDataSource(new ObjectProperty<Enum>(MyEnum.FIRST_VALUE));
        addComponent(tf);
    }

}
