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
import com.vaadin.shared.ui.ui.UIState.PushConfigurationState;

@Push(transport = Transport.WEBSOCKET)
public class PushLargeDataWebsocket extends PushLargeData {

    @Override
    protected void setup(VaadinRequest request) {
        super.setup(request);
        getPushConfiguration().setParameter(
                PushConfigurationState.FALLBACK_TRANSPORT_PARAM, "none");
    }
}
