/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.grid;

import java.io.Serializable;

/**
 * Container class for common constants and default values used by the Grid
 * component.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public final class GridConstants implements Serializable {

    /**
     * Enum describing different sections of Grid.
     *
     * @since 7.6
     */
    public enum Section {
        HEADER, BODY, FOOTER
    }

    /**
     * Default padding in pixels when scrolling programmatically, without an
     * explicitly defined padding value.
     */
    public static final int DEFAULT_PADDING = 0;

    /**
     * Delay before a long tap action is triggered. Number in milliseconds.
     */
    public static final int LONG_TAP_DELAY = 500;

    /**
     * The threshold in pixels a finger can move while long tapping.
     */
    public static final int LONG_TAP_THRESHOLD = 3;

    /* Column constants */

    /**
     * Default maximum width for columns.
     */
    public static final double DEFAULT_MAX_WIDTH = -1;

    /**
     * Default minimum width for columns.
     */
    public static final double DEFAULT_MIN_WIDTH = 10.0d;

    /**
     * Default expand ratio for columns.
     */
    public static final int DEFAULT_EXPAND_RATIO = -1;

    /**
     * Default width for columns.
     */
    public static final double DEFAULT_COLUMN_WIDTH_PX = -1;

    /**
     * Event ID for item click events
     */
    public static final String ITEM_CLICK_EVENT_ID = "itemClick";

    /** The default save button caption in the editor */
    public static final String DEFAULT_SAVE_CAPTION = "Save";

    /** The default cancel button caption in the editor */
    public static final String DEFAULT_CANCEL_CAPTION = "Cancel";

    /**
     * Event ID constant for editor open event
     */
    public static final String EDITOR_OPEN_EVENT_ID = "editorOpen";

    /**
     * Event ID constant for editor move event
     */
    public static final String EDITOR_MOVE_EVENT_ID = "editorMove";

    /**
     * Event ID constant for editor close event
     */
    public static final String EDITOR_CLOSE_EVENT_ID = "editorClose";
}
