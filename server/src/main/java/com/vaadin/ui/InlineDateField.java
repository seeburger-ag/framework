/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.ui;

import java.util.Date;

import com.vaadin.data.Property;

/**
 * <p>
 * A date entry component, which displays the actual date selector inline.
 *
 * </p>
 *
 * @see DateField
 * @see PopupDateField
 * @author Vaadin Ltd.
 * @since 5.0
 */
public class InlineDateField extends DateField {

    public InlineDateField() {
        super();
    }

    public InlineDateField(Property dataSource)
            throws IllegalArgumentException {
        super(dataSource);
    }

    public InlineDateField(String caption, Date value) {
        super(caption, value);
    }

    public InlineDateField(String caption, Property dataSource) {
        super(caption, dataSource);
    }

    public InlineDateField(String caption) {
        super(caption);
    }

}
