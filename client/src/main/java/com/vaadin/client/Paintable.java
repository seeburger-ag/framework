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
 * An interface used by client-side widgets or paintable parts to receive
 * updates from the corresponding server-side components in the form of
 * {@link UIDL}.
 *
 * Updates can be sent back to the server using the
 * {@link ApplicationConnection#updateVariable()} methods.
 */
@Deprecated
public interface Paintable {

    public void updateFromUIDL(UIDL uidl, ApplicationConnection client);
}
