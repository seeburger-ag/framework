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
import com.vaadin.tests.util.Millionaire;
import com.vaadin.ui.Form;

public class FormOneToMany extends TestBase {

    @Override
    protected void setup() {
        final Form form = new Form();
        addComponent(form);
        form.setItemDataSource(createMillionaireItem());

        // TODO support adding, editing and removing secondary addresses
    }

    protected BeanItem<Millionaire> createMillionaireItem() {
        Millionaire person = new Millionaire("First", "Last", "foo@vaadin.com",
                "02-111 2222", "Ruukinkatu 2-4", 20540, "Turku");

        BeanItem<Millionaire> item = new BeanItem<Millionaire>(person);
        // add nested properties from address
        item.expandProperty("address");

        // TODO for now, hide secondary residences
        item.removeItemProperty("secondaryResidences");

        return item;
    }

    @Override
    protected String getDescription() {
        return "Form with an editable list of sub-objects.";
    }

    @Override
    protected Integer getTicketNumber() {
        return null;
    }

}
