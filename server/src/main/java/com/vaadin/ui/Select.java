/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.ui;

import java.util.Collection;

import com.vaadin.data.Container;
import com.vaadin.data.Item;

/**
 * <p>
 * A class representing a selection of items the user has selected in a UI. The
 * set of choices is presented as a set of {@link Item}s in a {@link Container}.
 * </p>
 *
 * <p>
 * A <code>Select</code> component may be in single- or multiselect mode.
 * Multiselect mode means that more than one item can be selected
 * simultaneously.
 * </p>
 *
 * @author Vaadin Ltd.
 * @since 3.0
 * @deprecated As of 7.0. Use {@link ComboBox} instead.
 */
@Deprecated
public class Select extends ComboBox {
    /* Component methods */

    public Select() {
        super();
    }

    public Select(String caption, Collection<?> options) {
        super(caption, options);
    }

    public Select(String caption, Container dataSource) {
        super(caption, dataSource);
    }

    public Select(String caption) {
        super(caption);
    }

}
