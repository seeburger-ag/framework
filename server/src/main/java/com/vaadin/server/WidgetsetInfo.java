/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.server;

import java.io.Serializable;

/**
 * An interface describing the widgetset that the client should try to load.
 * <p>
 * In addition to explicit use within the framework, adding a class called
 * AppWidgetset implementing this interface in the default package will
 * configure the widgetset to use unless the user has explicitly selected a
 * different widgetset. See {@link BootstrapHandler} and {@link UIProvider} for
 * more information.
 *
 * @since 7.7
 */
public interface WidgetsetInfo extends Serializable {

    /**
     * Returns the name of the widgetset to use.
     *
     * @return widgetset name
     */
    public String getWidgetsetName();

    /**
     * Returns the widgetset URL. Can be null for local widgetsets at default
     * location.
     *
     * @return widgetset URL or null for client generated URL
     */
    public String getWidgetsetUrl();

    /**
     * If cdn is true, the client side should wait if it didn't manage to load
     * the widgetset, as it might still be compiling.
     *
     * @return true to wait and retry if the widgetset could not be loaded
     */
    public boolean isCdn();

}
