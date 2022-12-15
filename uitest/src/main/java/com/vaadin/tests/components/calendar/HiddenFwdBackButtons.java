/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.calendar;

import java.util.Date;
import java.util.Locale;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Calendar;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.components.calendar.CalendarComponentEvents.BackwardHandler;
import com.vaadin.ui.components.calendar.CalendarComponentEvents.ForwardHandler;

public class HiddenFwdBackButtons extends UI {

    @SuppressWarnings("deprecation")
    @Override
    protected void init(VaadinRequest request) {
        GridLayout content = new GridLayout(1, 2);
        content.setSizeFull();
        setContent(content);

        final Calendar calendar = new Calendar();
        calendar.setLocale(new Locale("fi", "FI"));

        calendar.setSizeFull();
        calendar.setStartDate(new Date(100, 1, 1));
        calendar.setEndDate(new Date(100, 1, 7));
        content.addComponent(calendar);
        Button button = new Button("Hide forward and back buttons");
        button.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                // This should hide the forward and back navigation buttons
                calendar.setHandler((BackwardHandler) null);
                calendar.setHandler((ForwardHandler) null);
            }
        });
        content.addComponent(button);

        content.setRowExpandRatio(0, 1);

    }
}
