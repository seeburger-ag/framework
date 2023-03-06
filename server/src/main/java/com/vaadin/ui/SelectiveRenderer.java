/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.ui;

/**
 * Interface implemented by {@link HasComponents} implementors that wish to
 * dynamically be able to prevent given child components from reaching the
 * client side.
 *
 * @author Vaadin Ltd
 * @version @VERSION@
 * @since 7.0
 *
 */
public interface SelectiveRenderer extends HasComponents {
    /**
     * Checks if the child component should be rendered (sent to the client
     * side). This method allows hiding a child component from updates and
     * communication to and from the client. It is mostly useful for parents
     * which show only a limited number of their children at any given time and
     * want to allow updates only for the visible children (e.g. TabSheet has
     * one tab open at a time).
     * <p>
     * This method can only prevent updates from reaching the client, not force
     * child components to reach the client. If the child is set to visible,
     * returning false will prevent the child from being sent to the client. If
     * a child is set to invisible, this method has no effect.
     * </p>
     *
     * @param childComponent
     *            The child component to check
     * @return true if the child component may be sent to the client, false
     *         otherwise
     */
    public boolean isRendered(Component childComponent);

}
