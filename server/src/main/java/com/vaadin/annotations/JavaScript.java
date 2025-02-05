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

import com.vaadin.server.ClientConnector;

/**
 * If this annotation is present on a {@link ClientConnector} class, the
 * framework ensures the referenced JavaScript files are loaded before the init
 * method for the corresponding client-side connector is invoked.
 * <p>
 * Absolute URLs including protocol and host are used as is on the client-side.
 * Relative URLs are mapped to APP/PUBLISHED/[url] which are by default served
 * from the classpath relative to the class where the annotation is defined.
 * <p>
 * The file is only loaded if it has not already been loaded, determined as
 * follows:
 * <ul>
 * <li>For absolute URLs, the URL is considered loaded if the same URL has
 * previously been loaded using {@code @JavaScript} or if a script tag loaded
 * from the same URL was present in the DOM when the Vaadin client-side was
 * initialized.
 * <li>For relative URLs, the URL is considered loaded if another file with the
 * same name has already been loaded using {@code @JavaScript}, even if that
 * file was loaded from a different folder.
 * </ul>
 * <p>
 * Example: <code>@JavaScript({"http://host.com/file1.js", "file2.js"})</code>
 * on the class com.example.MyConnector would load the file
 * http://host.com/file1.js as is and file2.js from /com/example/file2.js on the
 * server's classpath using the ClassLoader that was used to load
 * com.example.MyConnector.
 *
 * @author Vaadin Ltd
 * @since 7.0.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface JavaScript {
    /**
     * JavaScript files to load before initializing the client-side connector.
     *
     * @return an array of JavaScript file urls
     */
    public String[] value();
}
