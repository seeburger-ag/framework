/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.navigator;

import java.io.Serializable;

/**
 * An interface for handling interaction between {@link Navigator} and the
 * browser location URI or other similar view identification and bookmarking
 * system. The state is limited to a single string because in the usual cases it
 * forms a part of a URI.
 * <p>
 * Different implementations can be created for hashbang URIs, HTML5 pushState,
 * portlet URL navigation and other similar systems.
 * <p>
 * This interface is mostly for internal use by Navigator.
 *
 * @author Vaadin Ltd
 * @since 7.0
 */
public interface NavigationStateManager extends Serializable {
    /**
     * Returns the current navigation state including view name and any optional
     * parameters.
     *
     * @return current view and parameter string, not null
     */
    public String getState();

    /**
     * Sets the current navigation state in the location URI or similar
     * location, including view name and any optional parameters.
     * <p>
     * This method should be only called by a Navigator.
     *
     * @param fragment
     *            new view and parameter string, not null
     */
    public void setState(String state);

    /**
     * Sets the Navigator used with this state manager. The state manager should
     * notify the provided navigator of user-triggered navigation state changes
     * by invoking <code>navigator.navigateTo(getState())</code>.
     * {@code navigator} parameter value could be null if previously set
     * navigator is destroyed.
     * <p>
     * This method should only be called by a Navigator.
     */
    public void setNavigator(Navigator navigator);
}
