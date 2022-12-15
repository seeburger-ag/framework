/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.push;

import com.vaadin.annotations.Push;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ui.Transport;

@Push(transport = Transport.STREAMING)
public class BasicPushStreaming extends BasicPush {
    @Override
    public void init(VaadinRequest request) {
        super.init(request);
        // Don't use fallback so we can easier detect if streaming fails
        getPushConfiguration().setFallbackTransport(Transport.STREAMING);

    }
}
