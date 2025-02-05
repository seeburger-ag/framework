/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.shared.communication;

/**
 * The mode of bidirectional ("push") communication that is in use.
 *
 * @see com.vaadin.server.DeploymentConfiguration#getPushMode()
 *
 * @author Vaadin Ltd
 * @since 7.1
 */
public enum PushMode {
    /**
     * Push is disabled. Regular AJAX requests are used to communicate between
     * the client and the server. Asynchronous messages from the server are not
     * possible. {@link com.vaadin.ui.UI#push() ui.push()} throws
     * IllegalStateException.
     * <p>
     * This is the default mode unless
     * {@link com.vaadin.server.DeploymentConfiguration#getPushMode()
     * configured} otherwise.
     */
    DISABLED,

    /**
     * Push is enabled. A bidirectional channel is established between the
     * client and server and used to communicate state changes and RPC
     * invocations. The client is not automatically updated if the server-side
     * state is asynchronously changed; {@link com.vaadin.ui.UI#push()
     * ui.push()} must be explicitly called.
     */
    MANUAL,

    /**
     * Push is enabled. Like {@link #MANUAL}, but asynchronous changes to the
     * server-side state are automatically pushed to the client once the session
     * lock is released.
     */
    AUTOMATIC;

    /**
     * Checks whether the push mode is using push functionality
     *
     * @return <code>true</code> if this mode requires push functionality;
     *         <code>false</code> if no push functionality is used for this
     *         mode.
     */
    public boolean isEnabled() {
        return this != DISABLED;
    }
}
