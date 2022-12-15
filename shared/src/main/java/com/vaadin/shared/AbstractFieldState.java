/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared;

import com.vaadin.shared.ui.TabIndexState;

/**
 * Shared state for {@link com.vaadin.ui.AbstractField}.
 *
 * @author Vaadin Ltd
 * @since 7.0.0
 *
 */
public class AbstractFieldState extends TabIndexState {
    public boolean propertyReadOnly = false;
    public boolean hideErrors = false;
    public boolean required = false;
    public boolean modified = false;

    /**
     * The component which should receive focus events instead of the custom
     * field wrapper.
     * <p>
     * This is not used in all fields, but needs to be here for the time being
     * (#20468).
     * 
     * @since 7.7.5
     */
    public Connector focusDelegate;
}
