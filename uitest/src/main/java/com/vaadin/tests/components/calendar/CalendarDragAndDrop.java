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
package com.vaadin.tests.components.calendar;

import java.util.GregorianCalendar;
import java.util.Locale;

import com.vaadin.event.dd.DragAndDropEvent;
import com.vaadin.event.dd.DropHandler;
import com.vaadin.event.dd.acceptcriteria.AcceptAll;
import com.vaadin.event.dd.acceptcriteria.AcceptCriterion;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Calendar;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.TableDragMode;
import com.vaadin.ui.Table.TableTransferable;
import com.vaadin.ui.components.calendar.CalendarTargetDetails;
import com.vaadin.ui.components.calendar.event.BasicEvent;

public class CalendarDragAndDrop extends AbstractTestUI {

    private Calendar calendar;

    private Table table;

    private class TestDropHandler implements DropHandler {

        @Override
        public void drop(DragAndDropEvent event) {
            CalendarTargetDetails details = (CalendarTargetDetails) event
                    .getTargetDetails();

            TableTransferable transferable = (TableTransferable) event
                    .getTransferable();

            calendar.addEvent(new BasicEvent(
                    transferable.getItemId().toString(),
                    "This event was dragged here", details.getDropTime()));

            table.removeItem(transferable.getItemId());
        }

        @Override
        public AcceptCriterion getAcceptCriterion() {
            return AcceptAll.get();
        }
    }

    @Override
    protected void setup(VaadinRequest request) {
        setSizeFull();
        getContent().setSizeFull();
        getLayout().setSizeFull();

        HorizontalLayout root = new HorizontalLayout();
        root.setSizeFull();
        addComponent(root);

        Locale locale = new Locale("en", "US");
        GregorianCalendar cal = new GregorianCalendar(locale);
        cal.set(2013, 0, 1);

        calendar = new Calendar();
        calendar.setId("Calendar");
        calendar.setLocale(locale);
        calendar.setDropHandler(new TestDropHandler());
        calendar.setSizeFull();
        root.addComponent(calendar);

        calendar.setStartDate(cal.getTime());
        cal.add(java.util.Calendar.MONTH, 1);
        calendar.setEndDate(cal.getTime());

        table = new Table();
        table.setSizeFull();
        table.setDragMode(TableDragMode.ROW);
        table.addGeneratedColumn("COLUMN", new Table.ColumnGenerator() {

            @Override
            public Object generateCell(Table source, Object itemId,
                    Object columnId) {
                return itemId;
            }
        });

        for (int eventNum = 1; eventNum < 50; eventNum++) {
            table.addItem("Event " + eventNum);
        }

        root.addComponent(table);
    }

    @Override
    protected String getTestDescription() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Integer getTicketNumber() {
        return 11048;
    }

}
