/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.server;

import java.io.Serializable;

import com.vaadin.ui.UI;

/**
 * Gives out system messages based on Locale. Registered using
 * {@link VaadinService#setSystemMessagesProvider(SystemMessagesProvider)}.
 *
 * @author Vaadin Ltd
 * @since 7.0.0
 */
public interface SystemMessagesProvider extends Serializable {
    /**
     * Gets the system messages to use in the given context. The
     * {@link SystemMessagesInfo} object contains available information but in
     * most cases some or both of {@link VaadinSession#getCurrent()} and
     * {@link UI#getCurrent()} can also be used to find more information to help
     * the decision.
     *
     * @param systemMessagesInfo
     *            Locale, current request and other information available.
     * @return a system messages object
     */
    public SystemMessages getSystemMessages(
            SystemMessagesInfo systemMessagesInfo);
}
