/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.listselect;

import com.vaadin.data.util.IndexedContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUIWithLog;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ListSelect;

public class ListSelectAddRemoveItems extends AbstractTestUIWithLog {

    private IndexedContainer container = new IndexedContainer();

    @Override
    protected void setup(VaadinRequest request) {
        ListSelect listSelect = new ListSelect("ListSelect", container);
        listSelect.setWidth("100px");
        listSelect.setRows(10);

        resetContainer();
        logContainer();

        addComponent(listSelect);
        addComponent(new Button("Reset", new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                resetContainer();
                log.clear();
                logContainer();
            }
        }));

        addComponent(new Button("Add first", new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                container.addItemAt(0, "first");
                logContainer();
            }
        }));

        addComponent(new Button("Add middle", new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                container.addItemAt(container.size() / 2, "middle");
                logContainer();
            }
        }));

        addComponent(new Button("Add last", new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                container.addItem("last");
                logContainer();
            }
        }));

        addComponent(new Button("Swap", new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                Object lastItem = container.lastItemId();
                Object firstItem = container.firstItemId();
                if (lastItem != firstItem) {
                    container.removeItem(lastItem);
                    container.removeItem(firstItem);

                    container.addItemAt(0, lastItem);
                    container.addItem(firstItem);
                }

                logContainer();
            }
        }));

        addComponent(new Button("Remove first", new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                container.removeItem(container.firstItemId());
                logContainer();
            }
        }));

        addComponent(new Button("Remove middle", new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                container.removeItem(
                        container.getIdByIndex(container.size() / 2));
                logContainer();
            }
        }));

        addComponent(new Button("Remove last", new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                container.removeItem(container.lastItemId());
                logContainer();
            }
        }));

    }

    private void logContainer() {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < container.size(); i++) {
            Object id = container.getIdByIndex(i);
            if (i != 0) {
                b.append(", ");
            }
            b.append(id);
        }

        log(b.toString());
    }

    public void resetContainer() {
        container.removeAllItems();
        for (String value : new String[] { "a", "b", "c" }) {
            container.addItem(value);
        }
    }

    @Override
    protected String getTestDescription() {
        return "Test for verifying that items are added to and removed from the correct locations";
    }

}
