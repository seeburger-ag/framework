/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.client.ui;

import java.util.Date;

import com.google.gwt.event.dom.client.DomEvent;
import com.vaadin.client.DateTimeService;
import com.vaadin.client.ui.VCalendarPanel.FocusOutListener;
import com.vaadin.client.ui.VCalendarPanel.SubmitListener;
import com.vaadin.shared.ui.datefield.Resolution;

/**
 * A client side implementation for InlineDateField
 */
public class VDateFieldCalendar extends VDateField {

    /** For internal use only. May be removed or replaced in the future. */
    public final VCalendarPanel calendarPanel;

    public VDateFieldCalendar() {
        super();
        calendarPanel = new VCalendarPanel();
        calendarPanel.setParentField(this);
        add(calendarPanel);
        calendarPanel.setSubmitListener(new SubmitListener() {
            @Override
            public void onSubmit() {
                updateValueFromPanel();
            }

            @Override
            public void onCancel() {
                // TODO Auto-generated method stub

            }
        });
        calendarPanel.setFocusOutListener(new FocusOutListener() {
            @Override
            public boolean onFocusOut(DomEvent<?> event) {
                updateValueFromPanel();
                return false;
            }
        });
    }

    /**
     * TODO refactor: almost same method as in VPopupCalendar.updateValue
     * <p>
     * For internal use only. May be removed or replaced in the future.
     */

    @SuppressWarnings("deprecation")
    public void updateValueFromPanel() {

        // If field is invisible at the beginning, client can still be null when
        // this function is called.
        if (getClient() == null) {
            return;
        }

        Date date2 = calendarPanel.getDate();
        Date currentDate = getCurrentDate();
        if (currentDate == null || date2.getTime() != currentDate.getTime()) {
            setCurrentDate((Date) date2.clone());
            getClient().updateVariable(getId(), "year", date2.getYear() + 1900,
                    false);
            if (getCurrentResolution().getCalendarField() > Resolution.YEAR
                    .getCalendarField()) {
                getClient().updateVariable(getId(), "month",
                        date2.getMonth() + 1, false);
                if (getCurrentResolution().getCalendarField() > Resolution.MONTH
                        .getCalendarField()) {
                    getClient().updateVariable(getId(), "day", date2.getDate(),
                            false);
                    if (getCurrentResolution()
                            .getCalendarField() > Resolution.DAY
                                    .getCalendarField()) {
                        getClient().updateVariable(getId(), "hour",
                                date2.getHours(), false);
                        if (getCurrentResolution()
                                .getCalendarField() > Resolution.HOUR
                                        .getCalendarField()) {
                            getClient().updateVariable(getId(), "min",
                                    date2.getMinutes(), false);
                            if (getCurrentResolution()
                                    .getCalendarField() > Resolution.MINUTE
                                            .getCalendarField()) {
                                getClient().updateVariable(getId(), "sec",
                                        date2.getSeconds(), false);
                                if (getCurrentResolution()
                                        .getCalendarField() > Resolution.SECOND
                                                .getCalendarField()) {
                                    getClient().updateVariable(getId(),
                                            "msec", DateTimeService
                                                    .getMilliseconds(date2),
                                            false);
                                }
                            }
                        }
                    }
                }
            }
            if (isImmediate()) {
                getClient().sendPendingVariableChanges();
            }
        }
    }

    public void setTabIndex(int tabIndex) {
        calendarPanel.getElement().setTabIndex(tabIndex);
    }

    public int getTabIndex() {
        return calendarPanel.getElement().getTabIndex();
    }
}
