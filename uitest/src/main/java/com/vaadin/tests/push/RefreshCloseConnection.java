/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.push;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Push;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUIWithLog;

@Push
@PreserveOnRefresh
public class RefreshCloseConnection extends AbstractTestUIWithLog {

    @Override
    protected void setup(VaadinRequest request) {
        log("Init");
    }

    @Override
    protected void refresh(VaadinRequest request) {
        if (getPushConnection().isConnected()) {
            log("Still connected");
        }
        log("Refresh");
        new Thread() {
            @Override
            public void run() {
                accessSynchronously(new Runnable() {
                    @Override
                    public void run() {
                        log("Push");
                    }
                });
            }
        }.start();
    }

    @Override
    protected String getTestDescription() {
        return "A log row should get pushed after reloading the page";
    }

    @Override
    protected Integer getTicketNumber() {
        return Integer.valueOf(14251);
    }

}
