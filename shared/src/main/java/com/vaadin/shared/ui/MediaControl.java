/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.shared.ui;

import com.vaadin.shared.annotations.NoLayout;
import com.vaadin.shared.communication.ClientRpc;

/**
 * Server to client RPC interface for controlling playback of the media.
 *
 * @since 7.0
 */
public interface MediaControl extends ClientRpc {
    /**
     * Start playing the media.
     */
    @NoLayout
    public void play();

    /**
     * Pause playback of the media.
     */
    @NoLayout
    public void pause();
}
