/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.server.communication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Matchers.argThat;
import static org.mockito.Matchers.eq;

import org.atmosphere.cache.BroadcastMessage;
import org.atmosphere.cpr.AtmosphereRequest;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResource.TRANSPORT;
import org.atmosphere.cpr.BroadcastFilter.BroadcastAction;
import org.atmosphere.cpr.BroadcastFilter.BroadcastAction.ACTION;
import org.atmosphere.cpr.Broadcaster;
import org.atmosphere.cpr.BroadcasterCache;
import org.atmosphere.cpr.BroadcasterConfig;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;

import com.vaadin.server.communication.AtmospherePushConnection.PushMessage;

public class LongPollingCacheFilterTest {

    static final String RESOURCE_UUID = "resourceUUID";
    LongPollingCacheFilter filter = new LongPollingCacheFilter();

    PushMessage originalMessage = new PushMessage(5, "PUSH ME");
    Object nonPushMessage = new Object();
    Object message = new Object();
    private AtmosphereResource resource;
    private BroadcasterCache cache;

    @Test
    public void filter_notPushMessage_continueWithCurrentMessage() {
        setTransport(AtmosphereResource.TRANSPORT.LONG_POLLING);
        setSeenServerSyncIdHeader(5);
        BroadcastAction action = filter.filter("broadcasterId", resource,
                nonPushMessage, message);
        assertEquals(ACTION.CONTINUE, action.action());
        assertSame("Message should not be altered by filter", message,
                action.message());
        verifyMessageIsNotCached();
    }

    @Test
    public void filter_notLongPollingTransport_continueWithCurrentMessage() {
        setSeenServerSyncIdHeader(5);
        for (TRANSPORT transport : TRANSPORT.values()) {
            if (transport == AtmosphereResource.TRANSPORT.LONG_POLLING) {
                continue;
            }
            setTransport(transport);
            BroadcastAction action = filter.filter("broadcasterId", resource,
                    originalMessage, message);
            assertEquals(ACTION.CONTINUE, action.action());
            assertSame(
                    "Message should not be altered by filter "
                            + "when transport is " + transport,
                    message, action.message());
        }
        verifyMessageIsNotCached();
    }

    @Test
    public void filter_missingLastSeenServerSyncId_continueWithCurrentMessage() {
        setTransport(AtmosphereResource.TRANSPORT.LONG_POLLING);
        BroadcastAction action = filter.filter("broadcasterId", resource,
                originalMessage, message);
        assertEquals(ACTION.CONTINUE, action.action());
        assertSame(
                "Message should not be altered by filter "
                        + "if server sync id header is missing",
                message, action.message());
        verifyMessageIsNotCached();
    }

    @Test
    public void filter_messageAlreadySeen_abort() {
        setTransport(AtmosphereResource.TRANSPORT.LONG_POLLING);
        setSeenServerSyncIdHeader(5, 6);

        // seen server sync id == push message server sync id
        BroadcastAction action = filter.filter("broadcasterId", resource,
                originalMessage, message);
        assertEquals("Expecting message seen on client to be skipped",
                ACTION.ABORT, action.action());
        assertSame("Message should not be altered by filter when aborting",
                message, action.message());

        // seen server sync id > push message server sync id
        action = filter.filter("broadcasterId", resource, originalMessage,
                message);
        assertEquals("Expecting message seen on client to be skipped",
                ACTION.ABORT, action.action());
        assertSame("Message should not be altered by filter when aborting",
                message, action.message());
        verifyMessageIsNotCached();
    }

    @Test
    public void filter_messageNotYetSeen_addToCacheAndContinue() {
        setTransport(AtmosphereResource.TRANSPORT.LONG_POLLING);
        setSeenServerSyncIdHeader(2);
        String broadcasterId = "broadcasterId";
        BroadcastAction action = filter.filter(broadcasterId, resource,
                originalMessage, message);
        assertEquals("Expecting message not seen on client to be sent",
                ACTION.CONTINUE, action.action());
        assertSame("Message should not be altered by filter when continuing",
                message, action.message());
        Mockito.verify(cache).addToCache(eq(broadcasterId), eq(RESOURCE_UUID),
                argThat(new ArgumentMatcher<BroadcastMessage>() {
                    @Override
                    public boolean matches(Object m) {
                        if (m instanceof BroadcastMessage) {
                            return ((BroadcastMessage) m)
                                    .message() == originalMessage;
                        }
                        return false;
                    }
                }));
    }

    @Before
    public void setUp() {
        resource = Mockito.mock(AtmosphereResource.class);
        AtmosphereRequest request = Mockito.mock(AtmosphereRequest.class);
        Broadcaster broadcaster = Mockito.mock(Broadcaster.class);
        BroadcasterConfig broadcasterConfig = Mockito
                .mock(BroadcasterConfig.class);
        cache = Mockito.mock(BroadcasterCache.class);
        Mockito.when(broadcaster.getBroadcasterConfig())
                .thenReturn(broadcasterConfig);
        Mockito.when(broadcasterConfig.getBroadcasterCache()).thenReturn(cache);

        Mockito.when(resource.getBroadcaster()).thenReturn(broadcaster);
        Mockito.when(resource.getRequest()).thenReturn(request);
        Mockito.when(resource.uuid()).thenReturn(RESOURCE_UUID);
    }

    private void setTransport(AtmosphereResource.TRANSPORT transport) {
        Mockito.when(resource.transport()).thenReturn(transport);
    }

    private void setSeenServerSyncIdHeader(int id, int... ids) {
        String[] idStrings = new String[ids.length];
        for (int i = 0; i < ids.length; ++i) {
            idStrings[i] = String.valueOf(ids[i]);
        }
        Mockito.when(resource.getRequest()
                .getHeader(LongPollingCacheFilter.SEEN_SERVER_SYNC_ID))
                .thenReturn(Integer.toString(id), idStrings);

    }

    private void verifyMessageIsNotCached() {
        Mockito.verifyZeroInteractions(cache);
    }
}