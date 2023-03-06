/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.checkbox;

import com.vaadin.shared.AbstractFieldState;

public class CheckBoxState extends AbstractFieldState {
    {
        primaryStyleName = "v-checkbox";
    }

    public boolean checked = false;
}
