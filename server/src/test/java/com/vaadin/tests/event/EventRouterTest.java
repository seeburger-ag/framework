/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.event;

import java.lang.reflect.Method;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.vaadin.event.EventRouter;
import com.vaadin.server.ErrorEvent;
import com.vaadin.server.ErrorHandler;
import com.vaadin.ui.Component;
import com.vaadin.ui.Component.Listener;
import com.vaadin.util.ReflectTools;

/**
 * Test EventRouter and related error handling.
 */
public class EventRouterTest {

    private static final Method COMPONENT_EVENT_METHOD = ReflectTools
            .findMethod(Component.Listener.class, "componentEvent",
                    Component.Event.class);

    private EventRouter router;
    private Component component;
    private ErrorHandler errorHandler;
    private Listener listener;

    @Before
    public void createMocks() {
        router = new EventRouter();
        component = EasyMock.createNiceMock(Component.class);
        errorHandler = EasyMock.createMock(ErrorHandler.class);
        listener = EasyMock.createMock(Component.Listener.class);
        router.addListener(Component.Event.class, listener,
                COMPONENT_EVENT_METHOD);
    }

    @Test
    public void fireEvent_noException_eventReceived() {
        listener.componentEvent(EasyMock.<Component.Event> anyObject());

        EasyMock.replay(component, listener, errorHandler);
        router.fireEvent(new Component.Event(component), errorHandler);
        EasyMock.verify(listener, errorHandler);
    }

    @Test
    public void fireEvent_exceptionFromListenerAndNoHandler_exceptionPropagated() {
        listener.componentEvent(EasyMock.<Component.Event> anyObject());
        EasyMock.expectLastCall()
                .andThrow(new RuntimeException("listener failed"));

        EasyMock.replay(component, listener);
        try {
            router.fireEvent(new Component.Event(component));
            Assert.fail("Did not receive expected exception from listener");
        } catch (RuntimeException e) {
            // e is a ListenerMethod@MethodException
            Assert.assertEquals("listener failed", e.getCause().getMessage());
        }
        EasyMock.verify(listener);
    }

    @Test
    public void fireEvent_exceptionFromListener_errorHandlerCalled() {
        listener.componentEvent(EasyMock.<Component.Event> anyObject());
        EasyMock.expectLastCall()
                .andThrow(new RuntimeException("listener failed"));
        errorHandler.error(EasyMock.<ErrorEvent> anyObject());

        EasyMock.replay(component, listener, errorHandler);
        router.fireEvent(new Component.Event(component), errorHandler);
        EasyMock.verify(listener, errorHandler);
    }

    @Test
    public void fireEvent_multipleListenersAndException_errorHandlerCalled() {
        Listener listener2 = EasyMock.createMock(Component.Listener.class);
        router.addListener(Component.Event.class, listener2,
                COMPONENT_EVENT_METHOD);

        listener.componentEvent(EasyMock.<Component.Event> anyObject());
        EasyMock.expectLastCall()
                .andThrow(new RuntimeException("listener failed"));
        errorHandler.error(EasyMock.<ErrorEvent> anyObject());
        // second listener should be called despite an error in the first
        listener2.componentEvent(EasyMock.<Component.Event> anyObject());

        EasyMock.replay(component, listener, listener2, errorHandler);
        router.fireEvent(new Component.Event(component), errorHandler);
        EasyMock.verify(listener, listener2, errorHandler);
    }
}
