/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.dd;

import com.vaadin.client.ComponentConnector;

/**
 * Used to detect Widget from widget tree that has {@link #getDropHandler()}
 *
 * Decide whether to get rid of this class. If so, {@link VAbstractDropHandler}
 * must extend {@link ComponentConnector}.
 *
 */
public interface VHasDropHandler {
    public VDropHandler getDropHandler();
}
