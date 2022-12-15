/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.textfield;

import com.vaadin.shared.AbstractFieldState;
import com.vaadin.shared.annotations.NoLayout;

public class AbstractTextFieldState extends AbstractFieldState {
    {
        primaryStyleName = "v-textfield";
    }

    /**
     * Maximum character count in text field.
     */
    @NoLayout
    public int maxLength = -1;

    /**
     * Number of visible columns in the TextField.
     */
    public int columns = 0;

    /**
     * The prompt to display in an empty field. Null when disabled.
     */
    @NoLayout
    public String inputPrompt = null;

    /**
     * The text in the field
     */
    @NoLayout
    public String text = null;
}
