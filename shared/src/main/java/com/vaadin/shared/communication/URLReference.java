/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.communication;

import java.io.Serializable;

public class URLReference implements Serializable {

    private String URL;

    /**
     * Returns the URL that this object refers to.
     * <p>
     * Note that the URL can use special protocols like theme://
     *
     * @return The URL for this reference or null if unknown.
     */
    public String getURL() {
        return URL;
    }

    /**
     * Sets the URL that this object refers to
     *
     * @param URL
     */
    public void setURL(String URL) {
        this.URL = URL;
    }
}
