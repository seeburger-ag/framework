/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.shared.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import com.vaadin.shared.communication.ServerRpc;

/**
 * Invoking a method in a {@link ServerRpc} interface marked with this
 * annotation will only add the invocation to a queue of outgoing RPC
 * invocations, but it will not cause the queue to be purged and sent to the
 * server. The queue will instead be sent when any RPC method not marked
 * as @Delayed has been invoked.
 *
 * @author Vaadin Ltd
 * @version @VERSION@
 * @since 7.0.0
 */
@Target(ElementType.METHOD)
@Documented
public @interface Delayed {
    /**
     * By setting lastOnly to <code>true</code>, any previous invocations of the
     * same method will be removed from the queue when a new invocation is
     * added. This can be used in cases where only the last value is of
     * interest.
     * <p>
     * The default value is <code>false</code> which means that invoking the
     * method multiple times will cause multiple invocations to be enqueued and
     * eventually sent to the server.
     *
     * @return <code>true</code> if only the last invocation of the annotated
     *         method should be sent to the server, <code>false</code> if all
     *         enqueued invocations should be sent.
     */
    public boolean lastOnly() default false;
}
