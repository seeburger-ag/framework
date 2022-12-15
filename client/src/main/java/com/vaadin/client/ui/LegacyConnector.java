/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui;

import com.vaadin.client.ApplicationConnection;
import com.vaadin.client.Paintable;
import com.vaadin.client.UIDL;

/**
 * @deprecated This class is only intended to ease migration and should not be
 *             used for new projects.
 */
@Deprecated
public abstract class LegacyConnector extends AbstractComponentConnector
        implements Paintable {

    @Override
    public void updateFromUIDL(UIDL uidl, ApplicationConnection client) {
        ((Paintable) getWidget()).updateFromUIDL(uidl, client);
    }

}
