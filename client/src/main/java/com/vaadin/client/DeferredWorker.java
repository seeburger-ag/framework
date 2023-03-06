/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client;

/**
 * Give widgets and connectors the possibility to indicate to the framework that
 * there is work scheduled to be executed in the near future and that the
 * framework should wait for this work to complete before assuming the UI has
 * reached a steady state.
 *
 * @since 7.3
 * @author Vaadin Ltd
 */
public interface DeferredWorker {
    /**
     * Checks whether there are operations pending for this widget or connector
     * that must be executed before reaching a steady state.
     *
     * @returns <code>true</code> iff there are operations pending which must be
     *          executed before reaching a steady state
     */
    public boolean isWorkPending();
}
