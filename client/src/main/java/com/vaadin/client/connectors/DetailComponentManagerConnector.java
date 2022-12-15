/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.connectors;

import com.vaadin.client.ServerConnector;
import com.vaadin.client.extensions.AbstractExtensionConnector;
import com.vaadin.shared.ui.Connect;
import com.vaadin.ui.Grid.DetailComponentManager;

/**
 * Client-side connector for the DetailComponentManager of Grid.
 *
 * @since 7.6.1
 */
@Connect(DetailComponentManager.class)
public class DetailComponentManagerConnector
        extends AbstractExtensionConnector {

    @Override
    protected void extend(ServerConnector target) {
        // TODO: Move DetailsGenerator logic here.
    }

}
