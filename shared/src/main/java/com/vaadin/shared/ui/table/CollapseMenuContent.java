/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.shared.ui.table;

/**
 * Defines whether only collapsible columns should be shown to the user in the
 * column collapse menu.
 *
 * @see com.vaadin.ui.Table#setCollapseMenuContent(CollapseMenuContent)
 *
 * @since 7.6
 * @author Vaadin Ltd
 */
public enum CollapseMenuContent {
    /**
     * All columns are shown in the collapse menu. Columns that are not
     * collapsible are shown as disabled in the menu. This is the default
     * setting.
     */
    ALL_COLUMNS,

    /**
     * Only collapsible columns are shown in the collapse menu.
     */
    COLLAPSIBLE_COLUMNS;
}
