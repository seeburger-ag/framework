/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.event;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.impl.DOMImplStandard;
import com.vaadin.client.event.PointerEvent.EventType;

/**
 * Pointer event support class for IE 11+ (unprefixed pointer events)
 *
 * @since 7.2
 * @author Vaadin Ltd
 */

public class PointerEventSupportImplModernIE extends PointerEventSupportImpl {

    protected static boolean inited = false;

    @Override
    protected boolean isSupported() {
        return true;
    }

    @Override
    protected void init() {
        if (!inited) {
            JavaScriptObject eventDispatcherMapExtensions = JavaScriptObject
                    .createObject();
            JavaScriptObject captureEventDispatcherMapExtensions = JavaScriptObject
                    .createObject();
            for (EventType e : EventType.values()) {
                addEventDispatcher(e.getNativeEventName(),
                        eventDispatcherMapExtensions);
                getPointerEventCaptureDispatchers(e.getNativeEventName(),
                        captureEventDispatcherMapExtensions);
            }
            DOMImplStandard
                    .addBitlessEventDispatchers(eventDispatcherMapExtensions);
            DOMImplStandard.addCaptureEventDispatchers(
                    captureEventDispatcherMapExtensions);

            inited = true;
        }
    }

    private static native void addEventDispatcher(String eventName,
            JavaScriptObject jso)
    /*-{
        jso[eventName] = @com.google.gwt.user.client.impl.DOMImplStandard::dispatchEvent(*);
    }-*/;

    private static native void getPointerEventCaptureDispatchers(
            String eventName, JavaScriptObject jso)
    /*-{
        jso[eventName] = @com.google.gwt.user.client.impl.DOMImplStandard::dispatchCapturedMouseEvent(*);
    }-*/;

}
