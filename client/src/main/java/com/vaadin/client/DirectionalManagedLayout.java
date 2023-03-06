/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client;

import com.vaadin.client.ui.ManagedLayout;

public interface DirectionalManagedLayout extends ManagedLayout {
    public void layoutVertically();

    public void layoutHorizontally();
}
