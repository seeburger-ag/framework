/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client;

import java.util.Collection;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

public final class FastStringSet extends JavaScriptObject {
    protected FastStringSet() {
        // JSO constructor
    }

    public native boolean contains(String string)
    /*-{
        return this.hasOwnProperty(string);
    }-*/;

    public native void add(String string)
    /*-{
        this[string] = true;
    }-*/;

    public native void addAll(JsArrayString array)
    /*-{
        for(var i = 0; i < array.length; i++) {
            this[array[i]] = true;
        }
    }-*/;

    public native void addAll(FastStringSet set)
    /*-{
        for(var string in set) {
            if (Object.hasOwnProperty.call(set, string)) {
                this[string] = true;
            }
        }
    }-*/;

    public native JsArrayString dump()
    /*-{
        var array = [];
        for(var string in this) {
            if (this.hasOwnProperty(string)) {
                array.push(string);
            }
        }
        return array;
    }-*/;

    public native void remove(String string)
    /*-{
        delete this[string];
    }-*/;

    public native boolean isEmpty()
    /*-{
        for(var string in this) {
            if (this.hasOwnProperty(string)) {
                return false;
            }
        }
        return true;
    }-*/;

    public static FastStringSet create() {
        return JavaScriptObject.createObject().cast();
    }

    public native void addAllTo(Collection<String> target)
    /*-{
        for(var string in this) {
            if (Object.hasOwnProperty.call(this, string)) {
                target.@java.util.Collection::add(Ljava/lang/Object;)(string);
            }
        }
     }-*/;

    public native void removeAll(FastStringSet valuesToRemove)
    /*-{
        for(var string in valuesToRemove) {
            if (Object.hasOwnProperty.call(valuesToRemove, string)) {
                delete this[string];
            }
        }
    }-*/;
}
