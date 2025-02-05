/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.fieldgroup;

import com.vaadin.data.util.BeanItem;
import com.vaadin.tests.components.TestBase;
import com.vaadin.tests.util.Person;
import com.vaadin.ui.Form;

public class FormOneToOne extends TestBase {

    @Override
    protected void setup() {
        final Form form = new Form();
        addComponent(form);
        form.setItemDataSource(createPersonItem());
    }

    protected BeanItem<Person> createPersonItem() {
        Person person = new Person("First", "Last", "foo@vaadin.com",
                "02-111 2222", "Ruukinkatu 2-4", 20540, "Turku");

        BeanItem<Person> item = new BeanItem<Person>(person);
        // add nested properties from address
        item.expandProperty("address");

        return item;
    }

    @Override
    protected String getDescription() {
        return "Form where some properties come from a sub-object of the bean.";
    }

    @Override
    protected Integer getTicketNumber() {
        return null;
    }

}
