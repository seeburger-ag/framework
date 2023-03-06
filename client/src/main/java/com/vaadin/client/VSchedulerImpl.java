/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client;

import com.google.gwt.core.client.impl.SchedulerImpl;

public class VSchedulerImpl extends SchedulerImpl {

    /**
     * Keeps track of if there are deferred commands that are being executed. 0
     * == no deferred commands currently in progress, > 0 otherwise.
     */
    private int deferredCommandTrackers = 0;

    @Override
    public void scheduleDeferred(ScheduledCommand cmd) {
        deferredCommandTrackers++;
        super.scheduleDeferred(cmd);
        super.scheduleDeferred(new ScheduledCommand() {

            @Override
            public void execute() {
                deferredCommandTrackers--;
            }
        });
    }

    public boolean hasWorkQueued() {
        boolean hasWorkQueued = (deferredCommandTrackers != 0);
        return hasWorkQueued;
    }
}
