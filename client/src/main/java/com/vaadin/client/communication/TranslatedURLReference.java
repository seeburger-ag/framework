/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.communication;

import com.vaadin.client.ApplicationConnection;
import com.vaadin.shared.communication.URLReference;

/**
 * A URLReference implementation which does late URL translation to be able to
 * re-translate URLs if e.g. the theme changes
 *
 * @since 7.3
 * @author Vaadin Ltd
 */
public class TranslatedURLReference extends URLReference {

    private ApplicationConnection connection;

    /**
     * Sets the application connection this instance is connected to. Called
     * internally by the framework.
     *
     * @param connection
     *            the application connection this instance is connected to
     */
    public void setConnection(ApplicationConnection connection) {
        this.connection = connection;
    }

    @Override
    public String getURL() {
        return connection.translateVaadinUri(super.getURL());
    }

}
