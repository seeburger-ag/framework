/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.table;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

public class TableColumnAddAndResize extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        String people[][] = { { "Galileo", "Liked to go around the Sun" },
                { "Monnier", "Liked star charts" },
                { "VÃ€isÃ€lÃ€", "Liked optics" }, { "Oterma", "Liked comets" },
                { "Valtaoja", "Likes cosmology and still "
                        + "lives unlike the others above" }, };

        VerticalLayout content = new VerticalLayout();

        final Table table = new Table("Awesome Table");
        table.setSizeFull();
        table.addContainerProperty("Id1", String.class, "TestString");
        table.addContainerProperty("Id2", String.class, "TestString2");

        for (String[] p : people) {
            table.addItem(p);
        }
        table.setColumnWidth("Id1", 100);

        table.setColumnWidth("Id2", 100);

        table.setVisibleColumns("Id1");
        content.addComponent(table);
        Button button = new Button("Add and Resize");
        button.addClickListener(new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                table.setVisibleColumns("Id1", "Id2");
                table.setColumnWidth("Id2", 200);

            }
        });
        content.addComponent(button);
        addComponent(content);

    }
}
