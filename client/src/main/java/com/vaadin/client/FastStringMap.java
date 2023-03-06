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
import com.google.gwt.core.client.JsArrayString;

public final class FastStringMap<T> extends JavaScriptObject {

    protected FastStringMap() {
        // JSO constructor
    }

    public native void put(String key, T value)
    /*-{
         this[key] = value;
    }-*/;

    public native T get(String key)
    /*-{
         return this[key];
    }-*/;

    public native boolean containsKey(String key)
    /*-{
         //Can't use this.hasOwnProperty in case that key is used
         return Object.hasOwnProperty.call(this, key);
    }-*/;

    public native void remove(String key)
    /*-{
         delete this[key];
    }-*/;

    public native JsArrayString getKeys()
    /*-{
        var keys = [];
        for(var key in this) {
            if (Object.hasOwnProperty.call(this, key)) {
                keys.push(key);
            } 
        }
        return keys;
    }-*/;

    public native int size()
    /*-{
        var size = 0;
        for(var key in this) {
            if (Object.hasOwnProperty.call(this, key)) {
                size++;
            } 
        }
        return size;
    }-*/;

    public static <T> FastStringMap<T> create() {
        return JavaScriptObject.createObject().cast();
    }
}
