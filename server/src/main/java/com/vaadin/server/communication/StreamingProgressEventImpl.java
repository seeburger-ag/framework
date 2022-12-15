/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.server.communication;

import com.vaadin.server.StreamVariable.StreamingProgressEvent;

@SuppressWarnings("serial")
final class StreamingProgressEventImpl extends AbstractStreamingEvent
        implements StreamingProgressEvent {

    public StreamingProgressEventImpl(final String filename, final String type,
            long contentLength, long bytesReceived) {
        super(filename, type, contentLength, bytesReceived);
    }

}
