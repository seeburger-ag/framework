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
 * <code>Resource</code> provided to the client terminal. Support for actually
 * displaying the resource type is left to the terminal.
 *
 * @author Vaadin Ltd.
 * @since 3.0
 */
public interface Resource extends Serializable {

    /**
     * Gets the MIME type of the resource.
     *
     * @return the MIME type of the resource.
     */
    public String getMIMEType();
}
