/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.calendar.schedule;

/**
 * For Calendar client-side internal use only.
 *
 * @since 7.1
 * @author Vaadin Ltd.
 *
 */
public interface HasTooltipKey {
    /**
     * Gets the key associated for the Widget implementing this interface. This
     * key is used for getting a tooltip title identified by the key
     *
     * @return the tooltip key
     */
    Object getTooltipKey();
}
