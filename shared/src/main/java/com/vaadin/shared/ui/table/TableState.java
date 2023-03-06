/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.table;

import com.vaadin.shared.ui.select.AbstractSelectState;

/**
 * Shared state for the Table component.
 *
 * @since 7.0
 */
public class TableState extends AbstractSelectState {
    {
        primaryStyleName = "v-table";
    }

    public CollapseMenuContent collapseMenuContent = TableConstants.DEFAULT_COLLAPSE_MENU_CONTENT;
}
