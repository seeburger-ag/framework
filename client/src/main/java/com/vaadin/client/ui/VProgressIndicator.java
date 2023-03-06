/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.client.ui;

import com.vaadin.shared.ui.progressindicator.ProgressIndicatorState;

/**
 *
 * @author Vaadin Ltd
 *
 * @deprecated as of 7.1, renamed to VProgressBar
 */
@Deprecated
public class VProgressIndicator extends VProgressBar {

    public VProgressIndicator() {
        super();
        setStylePrimaryName(ProgressIndicatorState.PRIMARY_STYLE_NAME);
    }
}
