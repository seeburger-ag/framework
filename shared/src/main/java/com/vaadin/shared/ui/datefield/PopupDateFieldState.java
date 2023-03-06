/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.datefield;

import com.vaadin.shared.annotations.NoLayout;

public class PopupDateFieldState extends TextualDateFieldState {
    public static final String DESCRIPTION_FOR_ASSISTIVE_DEVICES = "Arrow down key opens calendar element for choosing the date";

    {
        primaryStyleName = "v-datefield";
    }

    public boolean textFieldEnabled = true;
    @NoLayout
    public String descriptionForAssistiveDevices = DESCRIPTION_FOR_ASSISTIVE_DEVICES;
}
