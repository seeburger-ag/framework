/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.event;

import com.vaadin.client.event.PointerEvent.EventType;

/**
 * Pointer event support class for IE 10 ("ms" prefixed pointer events)
 *
 * @since 7.2
 * @author Vaadin Ltd
 */
public class PointerEventSupportImplIE10
        extends PointerEventSupportImplModernIE {

    @Override
    public String getNativeEventName(EventType eventName) {
        return "MS" + eventName;
    }

}
