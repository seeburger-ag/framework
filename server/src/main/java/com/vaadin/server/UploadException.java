/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.server;

@SuppressWarnings("serial")
public class UploadException extends Exception {
    public UploadException(Exception e) {
        super("Upload failed", e);
    }

    public UploadException(String msg) {
        super(msg);
    }
}
