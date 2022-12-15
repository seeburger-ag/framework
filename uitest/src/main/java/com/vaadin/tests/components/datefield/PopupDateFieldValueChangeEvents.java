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
package com.vaadin.tests.components.datefield;

import java.util.Arrays;
import java.util.Calendar;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.tests.components.AbstractTestUIWithLog;
import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.NativeSelect;

/**
 *
 * @since
 * @author Vaadin Ltd
 */
public class PopupDateFieldValueChangeEvents extends AbstractTestUIWithLog {

    private int count = 0;

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.tests.components.AbstractTestUI#setup(com.vaadin.server.
     * VaadinRequest)
     */
    @Override
    protected void setup(VaadinRequest request) {

        HorizontalLayout hl = new HorizontalLayout();
        addComponent(hl);

        Calendar calendar = Calendar.getInstance();
        calendar.set(2010, 1, 1, 18, 19, 20);

        final DateField df = new DateField(null, calendar.getTime());
        df.setResolution(Resolution.SECOND);
        df.setImmediate(true);
        hl.addComponent(df);

        NativeSelect resolution = new NativeSelect(null,
                Arrays.asList(Resolution.values()));
        resolution.setImmediate(true);
        resolution.setValue(df.getResolution());
        hl.addComponent(resolution);
        resolution.addValueChangeListener(new ValueChangeListener() {

            @Override
            public void valueChange(ValueChangeEvent event) {
                df.setResolution((Resolution) event.getProperty().getValue());
            }
        });

        df.addValueChangeListener(new Property.ValueChangeListener() {

            @Override
            public void valueChange(ValueChangeEvent event) {
                log("Value changes: " + (++count));

            }
        });
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.tests.components.AbstractTestUI#getTestDescription()
     */
    @Override
    protected String getTestDescription() {
        return "DateField Time resolution fields should only send events when focus is removed";
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.tests.components.AbstractTestUI#getTicketNumber()
     */
    @Override
    protected Integer getTicketNumber() {
        return 6252;
    }

}
