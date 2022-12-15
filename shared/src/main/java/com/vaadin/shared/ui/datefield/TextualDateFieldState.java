/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.datefield;

import java.util.Date;

import com.vaadin.shared.AbstractFieldState;
import com.vaadin.shared.annotations.NoLayout;

public class TextualDateFieldState extends AbstractFieldState {
    {
        primaryStyleName = "v-datefield";
    }

    /*
     * Start range that has been cleared, depending on the resolution of the
     * date field
     */
    @NoLayout
    public Date rangeStart = null;

    /*
     * End range that has been cleared, depending on the resolution of the date
     * field
     */
    @NoLayout
    public Date rangeEnd = null;
}
