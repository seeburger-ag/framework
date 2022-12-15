/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid;

import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;

public class JavaScriptRenderers extends AbstractTestUI {

    private Grid grid;

    public static class MyBean {
        private int integer;
        private String string;

        public MyBean(int integer, String string) {
            super();
            this.integer = integer;
            this.string = string;
        }

        public int getInteger() {
            return integer;
        }

        public void setInteger(int integer) {
            this.integer = integer;
        }

        public String getString() {
            return string;
        }

        public void setString(String string) {
            this.string = string;
        }
    }

    @Override
    protected void setup(VaadinRequest request) {
        final IndexedContainer container = new IndexedContainer();
        container.addContainerProperty("id", Integer.class, Integer.valueOf(0));
        container.addContainerProperty("bean", MyBean.class, null);
        container.addContainerProperty("string", String.class, "");
        container.addContainerProperty("string2", String.class, "");

        for (int i = 0; i < 1000; i++) {
            Integer itemId = Integer.valueOf(i);
            Item item = container.addItem(itemId);
            item.getItemProperty("id").setValue(itemId);
            item.getItemProperty("bean")
                    .setValue(new MyBean(i + 1, Integer.toString(i - 1)));
            item.getItemProperty("string").setValue("string" + i);
        }
        Label clientLog = new Label();
        clientLog.setId("clientLog");
        addComponent(clientLog);
        grid = createGrid(container);
        addComponent(grid);

        addComponent(new Button("Recreate grid", new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                Grid newGrid = createGrid(container);
                replaceComponent(grid, newGrid);
                grid = newGrid;

            }
        }));
    }

    private Grid createGrid(IndexedContainer container) {
        Grid grid = new Grid(container);

        grid.getColumn("bean").setRenderer(new MyBeanJSRenderer());
        grid.getColumn("bean").setWidth(250);

        grid.getColumn("string").setRenderer(new JavaScriptStringRenderer());
        grid.getColumn("string2")
                .setRenderer(new JavaScriptStringRendererWithDestoryMethod());
        return grid;
    }

}
