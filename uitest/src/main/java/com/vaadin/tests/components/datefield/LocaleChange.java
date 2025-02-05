/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.datefield;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.DateField;

public class LocaleChange extends AbstractTestUI {

    private final Locale locale12hClock = Locale.US;
    private final Locale locale24hClock = Locale.FRANCE;

    private final String caption = "Switch to %s hour clock";
    private static final Date dateValue;
    static {
        try {
            dateValue = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
                    .parse("2014-05-22 20:00:00");
        } catch (ParseException e) {
            throw new ExceptionInInitializerError("Should never happen.");
        }
    }

    @Override
    protected void setup(VaadinRequest request) {
        final DateField df = new DateField();
        df.setLocale(locale24hClock);
        df.setResolution(Resolution.SECOND);
        df.setValue(dateValue);

        Button button = new Button(String.format(caption, "12"));
        button.addClickListener(new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                if (locale12hClock.equals(df.getLocale())) {
                    df.setLocale(locale24hClock);
                    event.getButton().setCaption(String.format(caption, "12"));
                } else {
                    df.setLocale(locale12hClock);
                    event.getButton().setCaption(String.format(caption, "24"));
                }
            }
        });

        addComponent(df);
        addComponent(button);
    }

    @Override
    protected String getTestDescription() {
        return "Testing locale change from one with 24h clock to a 12h clock locale.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 13722;
    }
}