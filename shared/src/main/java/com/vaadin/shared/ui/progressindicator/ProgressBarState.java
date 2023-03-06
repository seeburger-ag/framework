/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.shared.ui.progressindicator;

import com.vaadin.shared.AbstractFieldState;
import com.vaadin.shared.annotations.NoLayout;
import com.vaadin.shared.communication.SharedState;

/**
 * {@link SharedState} for {@link com.vaadin.ui.ProgressBar}
 *
 * @since 7.1
 * @author Vaadin Ltd
 */
public class ProgressBarState extends AbstractFieldState {
    public static final String PRIMARY_STYLE_NAME = "v-progressbar";

    {
        primaryStyleName = PRIMARY_STYLE_NAME;
    }
    public boolean indeterminate = false;
    @NoLayout
    public Float state = 0.0f;

}
