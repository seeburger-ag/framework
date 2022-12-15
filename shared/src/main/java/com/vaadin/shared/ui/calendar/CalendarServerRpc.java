/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.calendar;

import com.vaadin.shared.annotations.Delayed;
import com.vaadin.shared.communication.ServerRpc;

/**
 * @since 7.1
 * @author Vaadin Ltd.
 */
public interface CalendarServerRpc extends ServerRpc {
    void eventMove(int eventIndex, String newDate);

    void rangeSelect(String range);

    void forward();

    void backward();

    void dateClick(String date);

    void weekClick(String event);

    void eventClick(int eventIndex);

    void eventResize(int eventIndex, String newStartDate, String newEndDate);

    void actionOnEmptyCell(String actionKey, String startDate, String endDate);

    void actionOnEvent(String actionKey, String startDate, String endDate,
            int eventIndex);

    @Delayed(lastOnly = true)
    void scroll(int scrollPosition);
}
