/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.contextclick;

import com.vaadin.data.Item;
import com.vaadin.shared.ui.table.TableConstants.Section;
import com.vaadin.tests.util.PersonContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.TableContextClickEvent;

public class TableContextClick
        extends AbstractContextClickUI<Table, TableContextClickEvent> {

    @Override
    protected Table createTestComponent() {
        Table table = new Table();
        table.setContainerDataSource(PersonContainer.createWithTestData());
        table.setFooterVisible(true);
        table.setHeight("400px");
        return table;
    }

    @Override
    protected void handleContextClickEvent(TableContextClickEvent event) {
        String value = "";
        Object propertyId = event.getPropertyId();
        if (event.getItemId() != null) {
            Item item = event.getComponent().getContainerDataSource()
                    .getItem(event.getItemId());
            value += item.getItemProperty("firstName").getValue() + " ";
            value += item.getItemProperty("lastName").getValue();
        } else if (event.getSection() == Section.HEADER) {
            value = testComponent.getColumnHeader(propertyId);
        } else if (event.getSection() == Section.FOOTER) {
            value = testComponent.getColumnFooter(propertyId);
        }
        log("ContextClickEvent value: " + value + ", propertyId: " + propertyId
                + ", section: " + event.getSection());
    }

    @Override
    protected HorizontalLayout createContextClickControls() {
        HorizontalLayout controls = super.createContextClickControls();
        controls.addComponent(
                new Button("Remove all content", new Button.ClickListener() {

                    @Override
                    public void buttonClick(ClickEvent event) {
                        testComponent.getContainerDataSource().removeAllItems();
                    }
                }));
        return controls;
    }
}
