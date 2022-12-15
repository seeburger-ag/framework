/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.ui;

import java.io.Serializable;

/**
 * The shared state of a {@link com.vaadin.server.Page Page}.
 *
 * Note that at the moment this is not a stand-alone state class but embedded in
 * {@link UIState}. This might change in the future.
 *
 * @since 7.1
 */
public class PageState implements Serializable {
    /**
     * True if the page has browser window resize listeners.
     */
    public boolean hasResizeListeners = false;

    /**
     * Non-null if the title is set. Null means Vaadin does not touch the title.
     */
    public String title = null;
}
