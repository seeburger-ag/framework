/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid;

import com.vaadin.data.Container.Indexed;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.SelectionEvent;
import com.vaadin.event.SelectionEvent.SelectionListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUIWithLog;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;

public class GridReplaceContainer extends AbstractTestUIWithLog {

    @Override
    protected void setup(VaadinRequest request) {
        final Grid grid = new Grid();
        grid.setSelectionMode(SelectionMode.SINGLE);
        grid.setContainerDataSource(createContainer());
        grid.addSelectionListener(new SelectionListener() {

            @Override
            public void select(SelectionEvent event) {
                Bean selected = (Bean) grid.getSelectedRow();
                if (selected != null) {
                    log("Now selected: " + selected.getData());
                } else {
                    log("Now selected: null");
                }

            }
        });
        addComponent(grid);
        Button b = new Button("Re-set data source", new Button.ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                grid.setContainerDataSource(createContainer());
            }
        });
        addComponent(b);
    }

    public static class Bean {
        private int id;
        private String data;

        public Bean(int id, String data) {
            this.id = id;
            this.data = data;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

    }

    private Indexed createContainer() {
        BeanItemContainer<Bean> bic = new BeanItemContainer<Bean>(Bean.class);
        bic.addBean(new Bean(1, "First item"));
        bic.addBean(new Bean(2, "Second item"));
        bic.addBean(new Bean(3, "Third item"));
        return bic;
    }
}
