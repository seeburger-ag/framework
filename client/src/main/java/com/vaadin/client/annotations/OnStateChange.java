/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.vaadin.client.communication.StateChangeEvent;

/**
 * Marks a method in Connector classes that should be used to handle changes to
 * specific properties in the connector's shared state.
 * <p>
 * The annotated method will be called whenever at least one of the named state
 * properties have changed. If multiple listened properties are changed by the
 * same {@link StateChangeEvent}, the method will only be called once.
 * <p>
 * If there is no state variable with the provided name, the widgetset
 * compilation will fail.
 *
 * @since 7.2
 * @author Vaadin Ltd
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface OnStateChange {
    /**
     * Defines a list of property names to listen for.
     *
     * @return an array of property names, should contain at least one item
     */
    public String[] value();
}
