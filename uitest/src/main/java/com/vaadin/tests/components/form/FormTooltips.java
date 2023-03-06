/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.form;

import java.util.Arrays;

import com.vaadin.data.util.BeanItem;
import com.vaadin.server.UserError;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.tests.data.bean.Person;
import com.vaadin.tests.data.bean.Sex;
import com.vaadin.ui.Form;
import com.vaadin.ui.TextField;

public class FormTooltips extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        final Form form = new Form();
        form.setId("tooltipForm");
        form.setDescription("Some description");
        form.setItemDataSource(
                new BeanItem<Person>(
                        new Person("foo", "bar", "baz", 12, Sex.MALE, null)),
                Arrays.asList(new String[] { "firstName", "lastName", "age" }));
        ((TextField) form.getField("firstName"))
                .setDescription("Fields own tooltip");

        form.setComponentError(new UserError("Form error"));
        addComponent(form);

    }

    @Override
    protected String getTestDescription() {
        return "The 'first name' should show its own tooltip, the other fields should show no tooltip";
    }

    @Override
    protected Integer getTicketNumber() {
        return 9173;
    }

}
