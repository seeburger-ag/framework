/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.textarea;

import com.vaadin.shared.annotations.DelegateToWidget;
import com.vaadin.shared.annotations.NoLayout;
import com.vaadin.shared.ui.textfield.AbstractTextFieldState;

public class TextAreaState extends AbstractTextFieldState {
    {
        primaryStyleName = "v-textarea";
    }

    /**
     * Number of visible rows in the text area. The default is 5.
     */
    @DelegateToWidget
    public int rows = 5;

    /**
     * Tells if word-wrapping should be used in the text area.
     */
    @DelegateToWidget
    @NoLayout
    public boolean wordwrap = true;

}
