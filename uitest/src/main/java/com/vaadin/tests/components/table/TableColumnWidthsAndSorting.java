/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.table;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUIWithLog;
import com.vaadin.tests.fieldgroup.ComplexPerson;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Table;

@Theme("valo")
public class TableColumnWidthsAndSorting extends AbstractTestUIWithLog {

    @Override
    protected void setup(VaadinRequest request) {
        final Table t = new Table();
        t.setContainerDataSource(ComplexPerson.createContainer(100));
        t.setVisibleColumns("firstName", "lastName", "age", "gender", "salary");
        t.setColumnWidth("firstName", 200);
        t.setColumnWidth("lastName", 200);
        t.setSelectable(true);
        addComponent(t);

        Button b = new Button("Sort according to gender", new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                t.sort(new Object[] { "gender" }, new boolean[] { true });
            }
        });

        addComponent(b);
    }
}
