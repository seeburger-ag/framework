/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.progressindicator;

import com.vaadin.shared.annotations.NoLayout;

@Deprecated
public class ProgressIndicatorState extends ProgressBarState {
    public static final String PRIMARY_STYLE_NAME = "v-progressindicator";

    {
        primaryStyleName = PRIMARY_STYLE_NAME;
    }

    @NoLayout
    public int pollingInterval = 1000;
}
