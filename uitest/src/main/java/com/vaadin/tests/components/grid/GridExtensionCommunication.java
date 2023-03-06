/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid;

import com.vaadin.annotations.Widgetset;
import com.vaadin.data.Item;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.MouseEventDetails;
import com.vaadin.tests.components.AbstractTestUIWithLog;
import com.vaadin.tests.widgetset.TestingWidgetSet;
import com.vaadin.tests.widgetset.client.grid.GridClickExtensionConnector.GridClickServerRpc;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.AbstractGridExtension;
import com.vaadin.ui.Grid.Column;
import com.vaadin.ui.Grid.SelectionMode;

@Widgetset(TestingWidgetSet.NAME)
public class GridExtensionCommunication extends AbstractTestUIWithLog {

    public class GridClickExtension extends AbstractGridExtension {

        public GridClickExtension(Grid grid) {
            super(grid);
            registerRpc(new GridClickServerRpc() {

                @Override
                public void click(String row, String column,
                        MouseEventDetails click) {
                    Object itemId = getItemId(row);
                    Column col = getColumn(column);

                    Item person = getParentGrid().getContainerDataSource()
                            .getItem(itemId);

                    log("Click on Person "
                            + person.getItemProperty("firstName").getValue()
                            + " "
                            + person.getItemProperty("lastName").getValue()
                            + "  on column " + col.toString());
                    log("MouseEventDetails: " + click.getButtonName() + " ("
                            + click.getClientX() + ", " + click.getClientY()
                            + ")");
                }
            });
        }
    }

    @Override
    protected void setup(VaadinRequest request) {
        Grid grid = new PersonTestGrid(50);
        grid.setSelectionMode(SelectionMode.NONE);
        new GridClickExtension(grid);
        addComponent(grid);
    }

}
