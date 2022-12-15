/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.server.communication;

import java.util.concurrent.Future;

import org.atmosphere.cpr.AtmosphereRequest;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceEvent;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.vaadin.server.MockVaadinServletService;
import com.vaadin.server.MockVaadinSession;
import com.vaadin.server.ServiceException;
import com.vaadin.server.SessionExpiredException;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.UI;

public class PushHandlerTest {

    MockVaadinSession session = null;

    @Test
    public void connectionLost_currentInstancesAreCleared()
            throws SessionExpiredException, ServiceException {
        session = new MockVaadinSession() {
            @Override
            public Future<Void> access(Runnable runnable) {
                runnable.run();
                return Mockito.mock(Future.class);
            }
        };
        VaadinSession.setCurrent(session);
        Assert.assertNotNull(VaadinSession.getCurrent());
        MockVaadinServletService service = null;
        service = new MockVaadinServletService() {
            @Override
            public com.vaadin.server.VaadinSession findVaadinSession(
                    VaadinRequest request) throws SessionExpiredException {
                 return session;
            }

            @Override
            public UI findUI(VaadinRequest request) {
                return null;
            }
        };

        service.init();
        PushHandler handler = new PushHandler(service);

        AtmosphereResource resource = Mockito.mock(AtmosphereResource.class);
        AtmosphereRequest request = Mockito.mock(AtmosphereRequest.class);
        Mockito.when(resource.getRequest()).thenReturn(request);

        AtmosphereResourceEvent event = Mockito
                .mock(AtmosphereResourceEvent.class);
        Mockito.when(event.getResource()).thenReturn(resource);
        handler.connectionLost(event);

        Assert.assertNull(VaadinSession.getCurrent());
    }
}
