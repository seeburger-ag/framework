/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.server.communication;

import com.vaadin.server.StreamVariable.StreamingEvent;

/**
 * Abstract base class for StreamingEvent implementations.
 */
@SuppressWarnings("serial")
abstract class AbstractStreamingEvent implements StreamingEvent {
    private final String type;
    private final String filename;
    private final long contentLength;
    private final long bytesReceived;

    @Override
    public final String getFileName() {
        return filename;
    }

    @Override
    public final String getMimeType() {
        return type;
    }

    protected AbstractStreamingEvent(String filename, String type, long length,
            long bytesReceived) {
        this.filename = filename;
        this.type = type;
        contentLength = length;
        this.bytesReceived = bytesReceived;
    }

    @Override
    public final long getContentLength() {
        return contentLength;
    }

    @Override
    public final long getBytesReceived() {
        return bytesReceived;
    }

}
