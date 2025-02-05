/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.server.communication;

import java.io.Serializable;

import org.atmosphere.cache.BroadcastMessage;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.BroadcasterCache;
import org.atmosphere.cpr.PerRequestBroadcastFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.server.communication.AtmospherePushConnection.PushMessage;

/**
 * A {@link PerRequestBroadcastFilter} implementation that handles
 * {@link com.vaadin.server.communication.AtmospherePushConnection.PushMessage}s
 * to ensure that a message is preserved in the {@link BroadcasterCache} until
 * the client has received it.
 *
 * The filter acts only on {@literal LONG POLLING} transport and expects that
 * the client sends the {@literal X-Vaadin-LastSeenServerSyncId} header with the
 * identifier of the last message seen, every time the connection is
 * established.
 *
 * Messages already seen are discarded, whereas messages not yet sent to the
 * client are added again to the cache to preserve them until client confirms
 * reception by sending the last seen message identifier.
 */
public class LongPollingCacheFilter
        implements PerRequestBroadcastFilter, Serializable {
    public static final String SEEN_SERVER_SYNC_ID = "X-Vaadin-LastSeenServerSyncId";

    private static Logger getLogger() {
        return LoggerFactory.getLogger(LongPollingCacheFilter.class.getName());
    }

    @Override
    public BroadcastAction filter(String broadcasterId, AtmosphereResource r,
            Object originalMessage, Object message) {
        if (originalMessage instanceof PushMessage
                && r.transport() == AtmosphereResource.TRANSPORT.LONG_POLLING
                && r.getRequest().getHeader(SEEN_SERVER_SYNC_ID) != null) {
            PushMessage pushMessage = (PushMessage) originalMessage;
            String uuid = r.uuid();
            int lastSeenOnClient = Integer
                    .parseInt(r.getRequest().getHeader(SEEN_SERVER_SYNC_ID));
            if (pushMessage.alreadySeen(lastSeenOnClient)) {
                getLogger().trace(
                        "Discarding message {} for resource {} "
                                + "as client already seen {}. {}",
                        pushMessage.serverSyncId, uuid, lastSeenOnClient,
                        pushMessage.message);
                // Client has already seen this message, discard it
                return new BroadcastAction(BroadcastAction.ACTION.ABORT,
                        message);
            } else {
                // In rare cases with long polling, message may be lost during
                // write operation and the client may never receive it.
                // To prevent this kind of issues we move the message back to
                // the cache until we get confirmation that the message has been
                // seen
                getLogger().trace(
                        "Put message {} for resource {} back to the cache "
                                + "because it may not have reached the client, "
                                + "as the last seen message is {}. {}",
                        pushMessage.serverSyncId, uuid, lastSeenOnClient,
                        pushMessage.message);
                BroadcasterCache cache = r.getBroadcaster()
                        .getBroadcasterConfig().getBroadcasterCache();
                cache.addToCache(broadcasterId, uuid,
                        new BroadcastMessage(originalMessage));
            }
        }
        return new BroadcastAction(message);
    }

    @Override
    public BroadcastAction filter(String broadcasterId, Object originalMessage,
            Object message) {
        return new BroadcastAction(message);
    }

}