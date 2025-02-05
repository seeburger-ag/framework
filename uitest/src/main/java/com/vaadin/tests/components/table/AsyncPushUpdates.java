/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.table;

import com.vaadin.annotations.Push;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Table;

/**
 * Test to see if VScrollTable handles Push updates correctly.
 *
 * @author Vaadin Ltd
 */
@Push
public class AsyncPushUpdates extends AbstractTestUI {

    public int clickCount = 0;

    public static final String VALUE_PROPERTY_ID = "value";

    private final IndexedContainer container = createContainer();
    private final Table table = new Table();

    @Override
    public void setup(VaadinRequest request) {
        table.setWidth("100%");
        table.setContainerDataSource(container);

        Button button = new Button("START");
        button.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                ++clickCount;

                container.removeAllItems();
                for (int i = 0; i < 100; i++) {
                    container.getContainerProperty(container.addItem(),
                            VALUE_PROPERTY_ID).setValue("A" + i);
                }

                Runnable generateNewRows = new Runnable() {
                    public int id = 0;

                    @Override
                    public void run() {
                        getSession().lock();
                        try {
                            Thread.sleep(500);
                            ++id;
                            container.removeAllItems();
                            for (int i = 0; i < 11; i++) {
                                container.getContainerProperty(
                                        container.addItem(), VALUE_PROPERTY_ID)
                                        .setValue(clickCount + " - " + id
                                                + " - " + i);
                            }

                        } catch (InterruptedException e) {
                            // NOOP
                        } finally {
                            getSession().unlock();
                        }
                    }
                };
                new Thread(generateNewRows).start();
            }
        });
        addComponent(table);
        addComponent(button);
    }

    private static IndexedContainer createContainer() {
        IndexedContainer container = new IndexedContainer();
        container.addContainerProperty(VALUE_PROPERTY_ID, String.class, "");
        return container;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.tests.components.AbstractTestUI#getTestDescription()
     */
    @Override
    protected String getTestDescription() {
        return "Make sure there are no duplicates on the table.";
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.tests.components.AbstractTestUI#getTicketNumber()
     */
    @Override
    protected Integer getTicketNumber() {
        return 13562;
    }

}