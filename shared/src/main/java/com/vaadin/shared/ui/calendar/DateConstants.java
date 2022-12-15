/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.calendar;

import java.io.Serializable;

/**
 *
 * @since 7.1
 *
 */
public class DateConstants implements Serializable {

    public static final String ACTION_DATE_FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String CLIENT_DATE_FORMAT = "yyyy-MM-dd";
    public static final String CLIENT_TIME_FORMAT = "HH-mm";
    public static final long MINUTEINMILLIS = 60 * 1000;
    public static final long HOURINMILLIS = 60 * MINUTEINMILLIS;
    public static final long DAYINMILLIS = 24 * HOURINMILLIS;
    public static final long WEEKINMILLIS = 7 * DAYINMILLIS;

    public static final int DAYINMINUTES = 24 * 60;
    public static final int HOURINMINUTES = 60;

}
