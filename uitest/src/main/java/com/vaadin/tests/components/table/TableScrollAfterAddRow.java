/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.table;

import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author Vaadin Ltd
 */
@SuppressWarnings("serial")
public class TableScrollAfterAddRow extends AbstractTestUI {

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.ui.UI#init(com.vaadin.server.VaadinRequest)
     */
    @Override
    protected void setup(VaadinRequest request) {

        final int totalRows = 100;

        final VerticalLayout layout = new VerticalLayout();

        final IndexedContainer datasource = new IndexedContainer();

        datasource.addContainerProperty("value", Integer.class, -1);
        for (int i = 0; i < totalRows; i++) {
            addRow(datasource);
        }

        final Table table = new Table();
        table.setContainerDataSource(datasource);
        layout.addComponent(table);
        addComponent(layout);

        final Label label = new Label("");
        layout.addComponent(label);

        NativeButton addRowButton = new NativeButton("Add row",
                new NativeButton.ClickListener() {

                    @Override
                    public void buttonClick(ClickEvent event) {
                        addRow(datasource);
                    }
                });

        NativeButton jumpToLastRowButton = new NativeButton("Jump to last row",
                new NativeButton.ClickListener() {
                    @Override
                    public void buttonClick(ClickEvent event) {
                        jumpToLastRow(table);
                    }
                });
        NativeButton jumpTo15thRowButton = new NativeButton("Jump to 15th row",
                new NativeButton.ClickListener() {
                    @Override
                    public void buttonClick(ClickEvent event) {
                        jumpToFifteenthRow(table);
                    }
                });
        NativeButton jumpToFirstRowButton = new NativeButton(
                "Jump to first row", new NativeButton.ClickListener() {
                    @Override
                    public void buttonClick(ClickEvent event) {
                        jumpToFirstRow(table);
                    }
                });

        NativeButton updateLabelButton = new NativeButton("UpdateLabel",
                new NativeButton.ClickListener() {
                    @Override
                    public void buttonClick(ClickEvent event) {
                        label.setValue(Integer.toString(
                                table.getCurrentPageFirstItemIndex()));
                    }
                });
        layout.addComponent(addRowButton);
        layout.addComponent(jumpToLastRowButton);
        layout.addComponent(jumpTo15thRowButton);
        layout.addComponent(jumpToFirstRowButton);
        layout.addComponent(updateLabelButton);
    }

    private void jumpToFifteenthRow(Table table) {
        table.setCurrentPageFirstItemIndex(14);
    }

    private void jumpToLastRow(Table table) {
        int visibleRows = table.getContainerDataSource().size();
        table.setCurrentPageFirstItemIndex(visibleRows - 1);
    }

    private void jumpToFirstRow(Table table) {
        table.setCurrentPageFirstItemIndex(0);
    }

    private void addRow(IndexedContainer datasource) {
        int rowNumber = datasource.size();
        Item row = datasource.addItem(rowNumber);
        row.getItemProperty("value").setValue(rowNumber);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.tests.components.AbstractTestUI#getTestDescription()
     */
    @Override
    protected String getTestDescription() {
        // TODO Auto-generated method stub
        return "";
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.tests.components.AbstractTestUI#getTicketNumber()
     */
    @Override
    protected Integer getTicketNumber() {
        return 14147;
    }
}
