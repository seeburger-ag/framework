/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.minitutorials.v7_4;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.FooterCell;
import com.vaadin.ui.Grid.HeaderCell;
import com.vaadin.ui.Grid.HeaderRow;
import com.vaadin.ui.UI;

@Theme("valo")
public class ConfiguringGridHeadersAndFooters extends UI {
    @Override
    protected void init(VaadinRequest request) {
        Grid grid = new Grid(GridExampleHelper.createContainer());
        grid.setColumnOrder("name", "amount", "count");

        grid.getDefaultHeaderRow().getCell("amount")
                .setHtml("The <u>amount</u>");
        grid.getDefaultHeaderRow().getCell("count")
                .setComponent(new Button("Button caption"));

        grid.getColumn("name").setHeaderCaption("Bean name");

        HeaderRow extraHeader = grid.prependHeaderRow();
        HeaderCell joinedCell = extraHeader.join("amount", "count");
        joinedCell.setText("Joined cell");

        FooterCell footer = grid.appendFooterRow().join("name", "amount",
                "count");
        footer.setText("Right aligned footer");

        getPage().getStyles().add(".footer-right { text-align: right }");
        footer.setStyleName("footer-right");

        setContent(grid);
    }
}
