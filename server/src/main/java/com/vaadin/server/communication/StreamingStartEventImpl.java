/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.server.communication;

import com.vaadin.server.StreamVariable.StreamingStartEvent;

@SuppressWarnings("serial")
final class StreamingStartEventImpl extends AbstractStreamingEvent
        implements StreamingStartEvent {

    private boolean disposed;

    public StreamingStartEventImpl(final String filename, final String type,
            long contentLength) {
        super(filename, type, contentLength, 0);
    }

    @Override
    public void disposeStreamVariable() {
        disposed = true;
    }

    boolean isDisposed() {
        return disposed;
    }

}
