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
import com.vaadin.shared.ui.grid.GridConstants.Section;
import com.vaadin.tests.util.PersonContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.GridContextClickEvent;
import com.vaadin.ui.HorizontalLayout;

public class GridContextClick
        extends AbstractContextClickUI<Grid, GridContextClickEvent> {

    @Override
    protected Grid createTestComponent() {
        Grid grid = new Grid(PersonContainer.createWithTestData());
        grid.setFooterVisible(true);
        grid.appendFooterRow();

        grid.setColumnOrder("address", "email", "firstName", "lastName",
                "phoneNumber", "address.streetAddress", "address.postalCode",
                "address.city");

        grid.setWidth("100%");
        grid.setHeight("400px");

        return grid;
    }

    @Override
    protected void handleContextClickEvent(GridContextClickEvent event) {
        String value = "";
        Object propertyId = event.getPropertyId();
        if (event.getItemId() != null) {
            Item item = event.getComponent().getContainerDataSource()
                    .getItem(event.getItemId());
            value += item.getItemProperty("firstName").getValue();
            value += " " + item.getItemProperty("lastName").getValue();
        } else if (event.getSection() == Section.HEADER) {
            value = event.getComponent().getHeaderRow(event.getRowIndex())
                    .getCell(propertyId).getText();
        } else if (event.getSection() == Section.FOOTER) {
            value = event.getComponent().getFooterRow(event.getRowIndex())
                    .getCell(propertyId).getText();
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
