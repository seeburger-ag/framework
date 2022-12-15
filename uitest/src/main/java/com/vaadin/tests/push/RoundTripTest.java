/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.push;

import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.tests.widgetset.TestingWidgetSet;
import com.vaadin.tests.widgetset.server.RoundTripTester;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.TextField;

@Widgetset(TestingWidgetSet.NAME)
public class RoundTripTest extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        final RoundTripTester roundTripTester = new RoundTripTester();
        final TextField payloadSize = new TextField("Payload size (bytes)");
        payloadSize.setConverter(Integer.class);
        payloadSize.setConvertedValue(10000);
        if (request.getParameter("payload") != null) {
            payloadSize.setValue(request.getParameter("payload"));
        }
        addComponent(payloadSize);
        final TextField testDuration = new TextField("Test duration (ms)");
        testDuration.setConverter(Integer.class);
        testDuration.setConvertedValue(10000);
        addComponent(testDuration);
        if (request.getParameter("duration") != null) {
            testDuration.setValue(request.getParameter("duration"));
        }

        Button start = new Button("Start test");
        start.addClickListener(new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                roundTripTester.start(
                        (Integer) testDuration.getConvertedValue(),
                        (Integer) payloadSize.getConvertedValue());
            }
        });
        addComponent(roundTripTester);
        addComponent(start);

        if (request.getParameter("go") != null) {
            start.click();
        }
    }

    @Override
    protected String getTestDescription() {
        return "Tests how many roundtrips per second you can get using the given package size";
    }

    @Override
    protected Integer getTicketNumber() {
        return 11370;
    }

}
