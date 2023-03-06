/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.client;

import com.google.gwt.core.client.JavaScriptObject;

public final class JsArrayObject<T> extends JavaScriptObject {

    protected JsArrayObject() {
        // JSO constructor
    }

    public native void add(T value)
    /*-{
        this.push(value);
    }-*/;

    public native int size()
    /*-{
        return this.length;
    }-*/;

    public native T get(int i)
    /*-{
        return this[i];
    }-*/;

}
