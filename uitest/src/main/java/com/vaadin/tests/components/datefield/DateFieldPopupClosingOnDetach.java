/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.datefield;

import java.util.Timer;
import java.util.TimerTask;

import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.DateField;

public class DateFieldPopupClosingOnDetach extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        // Use polling to notice the removal of DateField.
        getUI().setPollInterval(500);

        final DateField df = new DateField();
        getLayout().addLayoutClickListener(new LayoutClickListener() {

            @Override
            public void layoutClick(LayoutClickEvent event) {
                // Use a background Thread to remove the DateField 1 second
                // after being clicked.
                TimerTask removeTask = new TimerTask() {

                    @Override
                    public void run() {
                        getUI().access(new Runnable() {
                            @Override
                            public void run() {
                                removeComponent(df);
                            }
                        });
                    }
                };
                new Timer(true).schedule(removeTask, 1000);
            }
        });

        addComponent(df);
    }

    @Override
    protected String getTestDescription() {
        return "DateField popup should be removed if it's open while the DateField is removed. "
                + "Click the popup open and a background Thread will remove the DateField after 1 second.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 18985;
    }

}
