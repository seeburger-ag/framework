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

/**
 * Defines a viewport tag that will be added to the HTML of the host page of a
 * UI class.
 * <p>
 * If you want to dynamically provide different viewport values for different
 * browser, you should use {@link ViewportGeneratorClass} instead.
 *
 * @since 7.4
 *
 * @author Vaadin Ltd
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Viewport {
    /**
     * Gets the viewport tag content.
     *
     * @return the viewport tag content
     */
    public String value();
}
