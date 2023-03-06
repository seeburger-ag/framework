/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.shared.ui.button;

import com.vaadin.shared.AbstractComponentState;
import com.vaadin.shared.annotations.NoLayout;
import com.vaadin.shared.ui.TabIndexState;

/**
 * Shared state for {@link com.vaadin.ui.Button} and
 * {@link com.vaadin.ui.NativeButton}.
 *
 * @see AbstractComponentState
 *
 * @since 7.0
 */
public class ButtonState extends TabIndexState {
    {
        primaryStyleName = "v-button";
    }
    @NoLayout
    public boolean disableOnClick = false;
    @NoLayout
    public int clickShortcutKeyCode = 0;
    @NoLayout
    public String iconAltText = "";
}
