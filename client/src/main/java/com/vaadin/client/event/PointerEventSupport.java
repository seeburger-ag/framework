/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.event;

import com.google.gwt.core.client.GWT;
import com.vaadin.client.event.PointerEvent.EventType;

/**
 * Main class for pointer event support. Contains functionality for determining
 * if pointer events are available or not.
 *
 * @since 7.2
 * @author Vaadin Ltd
 */
public class PointerEventSupport {

    private static final PointerEventSupportImpl impl = GWT
            .create(PointerEventSupportImpl.class);

    private PointerEventSupport() {
    }

    public static void init() {
        impl.init();
    }

    /**
     * @return true if pointer events are supported by the browser, false
     *         otherwise
     */
    public static boolean isSupported() {
        return impl.isSupported();
    }

    /**
     * @param eventType
     * @return the native event name of the given event
     */
    public static String getNativeEventName(EventType eventType) {
        return impl.getNativeEventName(eventType);
    }
}
