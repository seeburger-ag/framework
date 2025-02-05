/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.components.ui;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.vaadin.server.DefaultErrorHandler;
import com.vaadin.server.ErrorHandler;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.tests.components.AbstractTestUIWithLog;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.UI;
import com.vaadin.util.CurrentInstance;

public class UIAccessExceptionHandling extends AbstractTestUIWithLog
        implements ErrorHandler {

    private Future<Void> future;

    @Override
    protected void setup(VaadinRequest request) {
        getSession().setErrorHandler(this);

        addComponent(new Button("Throw RuntimeException on UI.access",
                new Button.ClickListener() {

                    @Override
                    public void buttonClick(ClickEvent event) {
                        log.clear();

                        // Ensure beforeClientResponse is invoked
                        markAsDirty();

                        future = access(new Runnable() {
                            @Override
                            public void run() {
                                throw new RuntimeException();
                            }
                        });
                    }
                }));

        addComponent(new Button("Throw RuntimeException on Session.access",
                new Button.ClickListener() {

                    @Override
                    public void buttonClick(ClickEvent event) {
                        log.clear();

                        // Ensure beforeClientResponse is invoked
                        markAsDirty();

                        VaadinService service = VaadinService.getCurrent();

                        future = service.accessSession(getSession(),
                                new Runnable() {

                                    @Override
                                    public void run() {
                                        throw new RuntimeException();
                                    }
                                });
                    }
                }));

        addComponent(
                new Button("Throw RuntimeException after removing instances",
                        new Button.ClickListener() {

                            @Override
                            public void buttonClick(ClickEvent event) {
                                log.clear();

                                // Ensure beforeClientResponse is invoked
                                markAsDirty();

                                assert UI
                                        .getCurrent() == UIAccessExceptionHandling.this;

                                Map<Class<?>, CurrentInstance> instances = CurrentInstance
                                        .getInstances(false);
                                CurrentInstance.clearAll();

                                assert UI.getCurrent() == null;

                                future = access(new Runnable() {
                                    @Override
                                    public void run() {
                                        throw new RuntimeException();
                                    }
                                });

                                CurrentInstance.restoreInstances(instances);
                            }
                        }));

        addComponent(new Button("Clear", new Button.ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                log.clear();
            }
        }));
    }

    @Override
    public void beforeClientResponse(boolean initial) {
        if (future != null) {
            try {
                future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                log("Exception caught on get: " + e.getClass().getName());
            } finally {
                future = null;
            }
        }
    }

    @Override
    public void error(com.vaadin.server.ErrorEvent event) {
        log("Exception caught on execution with "
                + event.getClass().getSimpleName() + " : "
                + event.getThrowable().getClass().getName());

        DefaultErrorHandler.doDefault(event);
    }

    @Override
    protected String getTestDescription() {
        return "Test for handling exceptions in UI.access and Session.access";
    }

    @Override
    protected Integer getTicketNumber() {
        return Integer.valueOf(12703);
    }

}
