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
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Layout;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class TableSizeInTabsheet extends AbstractTestUI {

    static final String TABLE = "table";
    static final String TABSHEET = "tabsheet";

    @Override
    protected void setup(VaadinRequest request) {
        VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);

        TabSheet tabSheet = new TabSheet();
        tabSheet.setId(TABSHEET);
        layout.addComponent(tabSheet);
        tabSheet.addTab(new TabComposite(), "Tab");
    }

    public class TabComposite extends CustomComponent {

        public TabComposite() {
            Layout mainLayout = new VerticalLayout();
            addComponent(mainLayout);
            setCompositionRoot(mainLayout);

            Component table = new Table();
            table.setWidth("100%");
            table.setId(TABLE);
            mainLayout.addComponent(table);
        }
    }

    @Override
    protected String getTestDescription() {
        return "The size calculations fails in IE8 when undefined size table is inside a tabsheet";
    }

    @Override
    protected Integer getTicketNumber() {
        return 12687;
    }

}
