/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.vaadin.ui.declarative.Design;

/**
 * Marks the component as the root of a design (html) file.
 * <p>
 * Used together with {@link Design#read(com.vaadin.ui.Component)} to be able
 * the load the design without further configuration. The design is loaded from
 * the same package as the annotated class and by default the design filename is
 * derived from the class name. Using the {@link #value()} parameter you can
 * specify another design file name.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DesignRoot {
    String value() default "";
}
