/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.client.extensions;

import com.vaadin.client.ServerConnector;
import com.vaadin.client.ui.AbstractConnector;

public abstract class AbstractExtensionConnector extends AbstractConnector {
    boolean hasBeenAttached = false;

    @Override
    public void setParent(ServerConnector parent) {
        ServerConnector oldParent = getParent();
        if (oldParent == parent) {
            // Nothing to do
            return;
        }
        if (hasBeenAttached && parent != null) {
            throw new IllegalStateException(
                    "An extension can not be moved from one parent to another.");
        }

        super.setParent(parent);

        if (parent != null) {
            extend(parent);
            hasBeenAttached = true;
        }
    }

    /**
     * Called when the extension is attached to its parent. This method is only
     * called once as an extension cannot be moved from one parent to another.
     *
     * @param target
     *            The connector this extension extends
     */
    protected abstract void extend(ServerConnector target);
}
