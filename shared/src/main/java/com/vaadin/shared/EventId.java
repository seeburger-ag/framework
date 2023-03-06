/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared;

import java.io.Serializable;

public interface EventId extends Serializable {
    public static final String BLUR = "blur";
    public static final String FOCUS = "focus";
    public static final String CLICK_EVENT_IDENTIFIER = "click";
    public static final String LAYOUT_CLICK_EVENT_IDENTIFIER = "lClick";
    public static final String POLL = "poll";
    public static final String CHANGE = "change";
    public static final String CONTEXT_CLICK = "cClick";
}
