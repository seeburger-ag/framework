/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.metadata;

import com.google.gwt.core.client.JavaScriptObject;
import com.vaadin.client.JsArrayObject;

/**
 * Special {@link Invoker} that uses JSNI to invoke methods with limited
 * visibility.
 *
 * @since 7.2
 * @author Vaadin Ltd
 */
public abstract class JsniInvoker implements Invoker {

    @Override
    public Object invoke(Object target, Object... params) {
        JsArrayObject<Object> jsParams = JavaScriptObject.createArray().cast();
        for (Object object : params) {
            jsParams.add(object);
        }
        return jsniInvoke(target, jsParams);
    }

    /**
     * Abstract method that will be generated to contain JSNI for invoking the
     * actual method.
     *
     * @param target
     *            the object upon which to invoke the method
     * @param params
     *            a js array with arguments to pass to the method
     * @return the value returned by the invoked method, or <code>null</code> if
     *         the target method return type is <code>void</code>.
     */
    protected abstract Object jsniInvoke(Object target,
            JsArrayObject<Object> params);

}
