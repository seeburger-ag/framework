/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.push;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.vaadin.annotations.Push;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.communication.PushMode;
import com.vaadin.shared.ui.ui.Transport;
import com.vaadin.tests.components.AbstractTestUIWithLog;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

@Push(value = PushMode.MANUAL, transport = Transport.LONG_POLLING)
public class ManualLongPollingPushUI extends AbstractTestUIWithLog {

    ExecutorService executor = Executors.newFixedThreadPool(1);

    @Override
    protected void setup(VaadinRequest request) {
        Button b = new Button("Manual push after 1s",
                new Button.ClickListener() {
                    @Override
                    public void buttonClick(ClickEvent event) {
                        executor.submit(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                access(new Runnable() {

                                    @Override
                                    public void run() {
                                        log("Logged after 1s, followed by manual push");
                                        push();
                                    }
                                });

                            }
                        });
                    }
                });
        addComponent(b);

        b = new Button("Double manual push after 1s",
                new Button.ClickListener() {
                    @Override
                    public void buttonClick(ClickEvent event) {
                        executor.submit(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                access(new Runnable() {

                                    @Override
                                    public void run() {
                                        log("First message logged after 1s, followed by manual push");
                                        push();
                                        log("Second message logged after 1s, followed by manual push");
                                        push();
                                    }
                                });

                            }
                        });
                    }
                });
        addComponent(b);

    }

}
