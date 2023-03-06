/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.client;

/**
 * ContainerResizedListener interface is useful for Widgets that support
 * relative sizes and who need some additional sizing logic.
 *
 * @deprecated As of 7.0, serves no purpose. Use {@link LayoutManager} and its
 *             methods instead.
 */
@Deprecated
public interface ContainerResizedListener {
    /**
     * This function is run when container box has been resized. Object
     * implementing ContainerResizedListener is responsible to call the same
     * function on its ancestors that implement NeedsLayout in case their
     * container has resized. runAnchestorsLayout(HasWidgets parent) function
     * from Util class may be a good helper for this.
     *
     * @deprecated As of 7.0, this method is never called by the framework.
     *
     */
    @Deprecated
    public void iLayout();
}
