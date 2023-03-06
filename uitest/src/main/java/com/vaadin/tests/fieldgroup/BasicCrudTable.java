/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.fieldgroup;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.BeanItem;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Table;

public class BasicCrudTable extends AbstractBasicCrud {

    private Table table;

    @Override
    protected void setup(VaadinRequest request) {
        super.setup(request);

        table = new Table();
        table.setSelectable(true);

        table.setContainerDataSource(container);

        table.setVisibleColumns((Object[]) columns);
        table.addValueChangeListener(new ValueChangeListener() {
            @Override
            public void valueChange(ValueChangeEvent event) {
                form.edit((BeanItem<ComplexPerson>) table
                        .getItem(table.getValue()));
            }
        });

        table.setSizeFull();

        addComponent(table);
        addComponent(form);
        getLayout().setExpandRatio(table, 1);
    }

    @Override
    protected void deselectAll() {
        table.setValue(null);

    }

}
