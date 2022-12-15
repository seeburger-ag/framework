/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.vaadin.server.ViewportGenerator;

/**
 * Defines a viewport tag generator class that will be used for generating the
 * content of a viewport tag that will be added to the HTML of the host page of
 * a UI class.
 * <p>
 * If you want to use the same viewport values for all requests, you can use the
 * simpler {@link Viewport} annotation instead.
 *
 * @see ViewportGenerator
 *
 * @since 7.4
 *
 * @author Vaadin Ltd
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface ViewportGeneratorClass {
    /**
     * Gets the viewport generator class to use. Please note that the class must
     * be public and have a default constructor. It must additionally be
     * declared as static if it's declared as an inner class.
     *
     * @return the viewport generator class
     */
    public Class<? extends ViewportGenerator> value();
}
