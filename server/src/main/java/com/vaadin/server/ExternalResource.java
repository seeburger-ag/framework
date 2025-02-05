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
import java.net.URL;

import com.vaadin.util.FileTypeResolver;

/**
 * <code>ExternalResource</code> implements source for resources fetched from
 * location specified by URL:s. The resources are fetched directly by the client
 * terminal and are not fetched trough the terminal adapter.
 *
 * @author Vaadin Ltd.
 * @since 3.0
 */
@SuppressWarnings("serial")
public class ExternalResource implements Resource, Serializable {

    /**
     * Url of the download.
     */
    private String sourceURL = null;

    /**
     * MIME Type for the resource
     */
    private String mimeType = null;

    /**
     * Creates a new download component for downloading directly from given URL.
     *
     * @param sourceURL
     *            the source URL.
     */
    public ExternalResource(URL sourceURL) {
        if (sourceURL == null) {
            throw new RuntimeException("Source must be non-null");
        }

        this.sourceURL = sourceURL.toString();
    }

    /**
     * Creates a new download component for downloading directly from given URL.
     *
     * @param sourceURL
     *            the source URL.
     * @param mimeType
     *            the MIME Type
     */
    public ExternalResource(URL sourceURL, String mimeType) {
        this(sourceURL);
        this.mimeType = mimeType;
    }

    /**
     * Creates a new download component for downloading directly from given URL.
     *
     * @param sourceURL
     *            the source URL.
     */
    public ExternalResource(String sourceURL) {
        if (sourceURL == null) {
            throw new RuntimeException("Source must be non-null");
        }

        this.sourceURL = sourceURL.toString();
    }

    /**
     * Creates a new download component for downloading directly from given URL.
     *
     * @param sourceURL
     *            the source URL.
     * @param mimeType
     *            the MIME Type
     */
    public ExternalResource(String sourceURL, String mimeType) {
        this(sourceURL);
        this.mimeType = mimeType;
    }

    /**
     * Gets the URL of the external resource.
     *
     * @return the URL of the external resource.
     */
    public String getURL() {
        return sourceURL;
    }

    /**
     * Gets the MIME type of the resource.
     *
     * @see com.vaadin.server.Resource#getMIMEType()
     */
    @Override
    public String getMIMEType() {
        if (mimeType == null) {
            mimeType = FileTypeResolver.getMIMEType(getURL().toString());
        }
        return mimeType;
    }

    /**
     * Sets the MIME type of the resource.
     */
    public void setMIMEType(String mimeType) {
        this.mimeType = mimeType;
    }
}
