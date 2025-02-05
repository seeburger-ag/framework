/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.components.ui;

import java.util.ArrayList;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUIWithLog;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.UI;
import com.vaadin.util.CurrentInstance;

public class CurrentUiRetained extends AbstractTestUIWithLog {
    public static class GcProbe {

    }

    @Override
    protected void setup(VaadinRequest request) {
        final ArrayList<UI> uiLog = new ArrayList<UI>();
        final ArrayList<Boolean> probeLog = new ArrayList<Boolean>();

        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    uiLog.add(UI.getCurrent());

                    GcProbe gcProbe = new GcProbe();
                    CurrentInstance.set(GcProbe.class, gcProbe);
                    probeLog.add(CurrentInstance.get(GcProbe.class) != null);
                    gcProbe = null;

                    Thread.sleep(500l);
                    System.gc();
                    Thread.sleep(500l);

                    probeLog.add(CurrentInstance.get(GcProbe.class) != null);
                    uiLog.add(UI.getCurrent());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

        addComponent(new Button("Show result", new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                try {
                    thread.join();

                    log("Correct UI.getCurrent before GC: "
                            + (uiLog.get(0) == CurrentUiRetained.this));
                    log("Correct UI.getCurrent after GC: "
                            + (uiLog.get(1) == CurrentUiRetained.this));

                    log("GC probe available before GC: " + probeLog.get(0));
                    log("GC probe available after GC: " + probeLog.get(1));

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }));
    }

    @Override
    protected String getTestDescription() {
        return "Tests that garbage collection removes stale CurrentInstance values while retaining values not collected.";
    }

    @Override
    protected Integer getTicketNumber() {
        return Integer.valueOf(12509);
    }

}
