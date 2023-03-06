/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.server.communication;

import com.vaadin.server.StreamVariable.StreamingEndEvent;

@SuppressWarnings("serial")
final class StreamingEndEventImpl extends AbstractStreamingEvent
        implements StreamingEndEvent {

    public StreamingEndEventImpl(String filename, String type,
            long totalBytes) {
        super(filename, type, totalBytes, totalBytes);
    }

}
