/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.minitutorials.v7b2;

import com.vaadin.server.ClientConnector.DetachListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

public class CleanupUI extends UI implements DetachListener {
    @Override
    protected void init(VaadinRequest request) {
        addDetachListener(new DetachListener() {
            @Override
            public void detach(DetachEvent event) {
                releaseSomeResources();
            }
        });

        // ...
        addDetachListener(this);
    }

    @Override
    public void detach(DetachEvent event) {
        releaseMoreResources();
    }

    private void releaseSomeResources() {
        // ...
    }

    private void releaseMoreResources() {
        // ...
    }
}
