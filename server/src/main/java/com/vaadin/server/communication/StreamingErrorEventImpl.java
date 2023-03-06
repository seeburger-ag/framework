/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.server.communication;

import com.vaadin.server.StreamVariable.StreamingErrorEvent;

@SuppressWarnings("serial")
final class StreamingErrorEventImpl extends AbstractStreamingEvent
        implements StreamingErrorEvent {

    private final Exception exception;

    public StreamingErrorEventImpl(final String filename, final String type,
            long contentLength, long bytesReceived, final Exception exception) {
        super(filename, type, contentLength, bytesReceived);
        this.exception = exception;
    }

    @Override
    public final Exception getException() {
        return exception;
    }

}
