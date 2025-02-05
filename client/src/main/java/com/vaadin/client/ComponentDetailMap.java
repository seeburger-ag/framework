/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client;

import java.util.ArrayList;
import java.util.Collection;

import com.google.gwt.core.client.JavaScriptObject;

final class ComponentDetailMap extends JavaScriptObject {

    protected ComponentDetailMap() {
    }

    static ComponentDetailMap create() {
        return (ComponentDetailMap) JavaScriptObject.createObject();
    }

    boolean isEmpty() {
        return size() == 0;
    }

    final native boolean containsKey(String key)
    /*-{
        return this.hasOwnProperty(key);
    }-*/;

    final native ComponentDetail get(String key)
    /*-{
        return this[key];
    }-*/;

    final native void put(String id, ComponentDetail value)
    /*-{
        this[id] = value;
    }-*/;

    final native void remove(String id)
    /*-{
        delete this[id];
    }-*/;

    final native int size()
    /*-{
        var count = 0;
        for(var key in this) {
            count++;
        }
        return count;
    }-*/;

    final native void clear()
    /*-{
        for(var key in this) {
            if(this.hasOwnProperty(key)) {
                delete this[key];
            }
        }
    }-*/;

    private final native void fillWithValues(Collection<ComponentDetail> list)
    /*-{
        for(var key in this) {
            // $entry not needed as function is not exported
            list.@java.util.Collection::add(Ljava/lang/Object;)(this[key]);
        }
    }-*/;

    final Collection<ComponentDetail> values() {
        ArrayList<ComponentDetail> list = new ArrayList<ComponentDetail>();
        fillWithValues(list);
        return list;
    }

    public native JsArrayObject<ComponentDetail> valuesAsJsArray()
    /*-{
        var result = [];
        for(var key in this) {
            if (this.hasOwnProperty(key)) {
                result.push(this[key]);
            }
        }
        return result;
    }-*/;

}
