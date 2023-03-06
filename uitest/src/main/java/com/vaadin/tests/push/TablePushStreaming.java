/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

/**
 *
 */
package com.vaadin.tests.push;

import com.vaadin.annotations.Push;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ui.Transport;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Table;

/**
 *
 * @since
 * @author Vaadin Ltd
 */
@Push(transport = Transport.STREAMING)
public class TablePushStreaming extends AbstractTestUI {

    private int iteration = 1;

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.tests.components.AbstractTestUI#setup(com.vaadin.server.
     * VaadinRequest)
     */
    @Override
    protected void setup(VaadinRequest request) {
        final Table t = new Table("The table");
        t.setContainerDataSource(generateContainer(10, 10, iteration++));
        t.setSizeFull();
        Runnable r = new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 99; i++) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    access(new Runnable() {

                        @Override
                        public void run() {
                            t.setContainerDataSource(generateContainer(
                                    t.getVisibleColumns().length, t.size(),
                                    iteration++));
                        }

                    });
                }

            }
        };
        Thread tr = new Thread(r);
        tr.start();

        setContent(t);
    }

    /**
     * @param iter
     * @since
     * @return
     */
    private Container generateContainer(int rows, int cols, int iter) {
        IndexedContainer ic = new IndexedContainer();
        for (int col = 1; col <= cols; col++) {
            ic.addContainerProperty("Property" + col, String.class, "");
        }

        for (int row = 0; row < rows; row++) {
            Item item = ic.addItem("row" + row);
            for (int col = 1; col <= cols; col++) {
                item.getItemProperty("Property" + col).setValue(
                        "Row " + row + " col " + col + "(" + iter + ")");
            }

        }

        return ic;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.tests.components.AbstractTestUI#getTestDescription()
     */
    @Override
    protected String getTestDescription() {
        return "Test that pushes Table data at a high pace to detect possible problems in the streaming protocol";
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.tests.components.AbstractTestUI#getTicketNumber()
     */
    @Override
    protected Integer getTicketNumber() {
        return null;
    }

}
