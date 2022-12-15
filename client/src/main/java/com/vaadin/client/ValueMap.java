/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
/**
 *
 */
package com.vaadin.client;

import java.util.HashSet;
import java.util.Set;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;

public final class ValueMap extends JavaScriptObject {
    protected ValueMap() {
    }

    public native double getRawNumber(final String name)
    /*-{
        return this[name];
    }-*/;

    public native int getInt(final String name)
    /*-{
        return this[name];
    }-*/;

    public native boolean getBoolean(final String name)
    /*-{
        return Boolean(this[name]);
    }-*/;

    public native String getString(String name)
    /*-{
        return this[name];
    }-*/;

    public native JsArrayString getKeyArray()
    /*-{
        var a = new Array();
        var attr = this;
        for(var j in attr) {
            // workaround for the infamous chrome hosted mode hack (__gwt_ObjectId)
            if(attr.hasOwnProperty(j))
                a.push(j);
        }
        return a;
    }-*/;

    public Set<String> getKeySet() {
        final HashSet<String> attrs = new HashSet<String>();
        JsArrayString attributeNamesArray = getKeyArray();
        for (int i = 0; i < attributeNamesArray.length(); i++) {
            attrs.add(attributeNamesArray.get(i));
        }
        return attrs;
    }

    public native JsArrayString getJSStringArray(String name)
    /*-{
        return this[name];
    }-*/;

    public native JsArray<ValueMap> getJSValueMapArray(String name)
    /*-{
        return this[name];
    }-*/;

    public String[] getStringArray(final String name) {
        JsArrayString stringArrayAttribute = getJSStringArray(name);
        final String[] s = new String[stringArrayAttribute.length()];
        for (int i = 0; i < stringArrayAttribute.length(); i++) {
            s[i] = stringArrayAttribute.get(i);
        }
        return s;
    }

    public int[] getIntArray(final String name) {
        JsArrayString stringArrayAttribute = getJSStringArray(name);
        final int[] s = new int[stringArrayAttribute.length()];
        for (int i = 0; i < stringArrayAttribute.length(); i++) {
            s[i] = Integer.parseInt(stringArrayAttribute.get(i));
        }
        return s;
    }

    public native boolean containsKey(final String name)
    /*-{
         return name in this;
    }-*/;

    public native ValueMap getValueMap(String name)
    /*-{
        return this[name];
    }-*/;

    public native String getAsString(String name)
    /*-{
        return '' + this[name];
    }-*/;

    public native JavaScriptObject getJavaScriptObject(String name)
    /*-{
        return this[name];
    }-*/;

}
