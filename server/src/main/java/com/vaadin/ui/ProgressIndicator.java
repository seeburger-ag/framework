/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.ui;

import com.vaadin.data.Property;
import com.vaadin.shared.communication.PushMode;
import com.vaadin.shared.ui.progressindicator.ProgressIndicatorServerRpc;
import com.vaadin.shared.ui.progressindicator.ProgressIndicatorState;

/**
 * A {@link ProgressBar} which polls the server for updates.
 * <p>
 * Polling in this way is generally not recommended since there is no
 * centralized management of when messages are sent to the server. Furthermore,
 * polling might not be needed at all if {@link UI#setPushMode(PushMode)} or
 * {@link UI#setPollInterval(int)} is used.
 *
 * @author Vaadin Ltd.
 * @since 4
 * @deprecated as of 7.1, use {@link ProgressBar} combined with
 *             {@link UI#setPushMode(PushMode)} or
 *             {@link UI#setPollInterval(int)} instead.
 */
@Deprecated
@SuppressWarnings("serial")
public class ProgressIndicator extends ProgressBar {

    private ProgressIndicatorServerRpc rpc = new ProgressIndicatorServerRpc() {

        @Override
        public void poll() {
            // Nothing to do.
        }
    };

    /**
     * Creates an a new ProgressIndicator.
     */
    public ProgressIndicator() {
        this(0.0f);
    }

    /**
     * Creates a new instance of ProgressIndicator with given state.
     *
     * @param value
     */
    public ProgressIndicator(float value) {
        super(value);
        registerRpc(rpc);
    }

    /**
     * Creates a new instance of ProgressIndicator with state read from the
     * given datasource.
     *
     * @param contentSource
     */
    public ProgressIndicator(Property contentSource) {
        super(contentSource);
        registerRpc(rpc);
    }

    @Override
    protected ProgressIndicatorState getState() {
        return (ProgressIndicatorState) super.getState();
    }

    @Override
    protected ProgressIndicatorState getState(boolean markAsDirty) {
        return (ProgressIndicatorState) super.getState(markAsDirty);
    }

    /**
     * Sets the interval that component checks for progress.
     *
     * @param pollingInterval
     *            the interval in milliseconds.
     */
    public void setPollingInterval(int pollingInterval) {
        getState().pollingInterval = pollingInterval;
    }

    /**
     * Gets the interval that component checks for progress.
     *
     * @return the interval in milliseconds.
     */
    public int getPollingInterval() {
        return getState(false).pollingInterval;
    }
}
