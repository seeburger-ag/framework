/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.table;

import com.vaadin.data.util.IndexedContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUIWithLog;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;

public class TableParentEnabledStateChange extends AbstractTestUIWithLog {

    private Button toggle;

    @Override
    protected void setup(VaadinRequest request) {

        addComponent(new Label(
                "Toggling the enabled state of the custom component will break the selectability of the row in the table. "));

        final MyCustomComponent customComponent = new MyCustomComponent();

        toggle = new Button(
                "Toggle enabled state ; " + customComponent.isEnabled());
        toggle.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                customComponent.setEnabled(!customComponent.isEnabled());
                toggle.setCaption("Toggle enabled state ; "
                        + customComponent.isEnabled());
            }
        });
        addComponent(toggle);
        addComponent(customComponent);

    }

    class MyCustomComponent extends CustomComponent {

        private static final long serialVersionUID = 1L;
        private FormLayout root;
        private Table table;
        private Button toggle;

        public MyCustomComponent() {
            root = new FormLayout();
            setCompositionRoot(root);
            setWidth("300px");
            setHeight("300px");

            table = new Table();
            table.setWidth("200px");
            table.setHeight("150px");
            table.setSelectable(true);

            IndexedContainer container = new IndexedContainer();
            container.addContainerProperty("name", String.class,
                    "Select this item");
            container.addItem(1);
            table.setContainerDataSource(container);

            root.addComponent(table);
        }
    }

}
