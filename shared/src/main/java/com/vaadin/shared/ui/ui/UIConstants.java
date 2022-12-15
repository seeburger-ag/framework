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

public class UIConstants implements Serializable {
    /**
     * Attribute name for the lazy resize setting .
     */
    @Deprecated
    public static final String RESIZE_LAZY = "rL";

    @Deprecated
    public static final String NOTIFICATION_HTML_CONTENT_NOT_ALLOWED = "useplain";

    @Deprecated
    public static final String LOCATION_VARIABLE = "location";

    @Deprecated
    public static final String ATTRIBUTE_NOTIFICATION_STYLE = "style";
    @Deprecated
    public static final String ATTRIBUTE_NOTIFICATION_CAPTION = "caption";
    @Deprecated
    public static final String ATTRIBUTE_NOTIFICATION_MESSAGE = "message";
    @Deprecated
    public static final String ATTRIBUTE_NOTIFICATION_ICON = "icon";
    @Deprecated
    public static final String ATTRIBUTE_NOTIFICATION_POSITION = "position";
    @Deprecated
    public static final String ATTRIBUTE_NOTIFICATION_DELAY = "delay";

    /**
     * Name of the parameter used to transmit UI ids back and forth
     */
    public static final String UI_ID_PARAMETER = "v-uiId";

}
