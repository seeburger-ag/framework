/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui;

import com.vaadin.shared.AbstractComponentState;
import com.vaadin.shared.annotations.NoLayout;

/**
 * Interface implemented by state classes that support tab indexes.
 *
 * @author Vaadin Ltd
 * @since 7.0.0
 *
 */
public class TabIndexState extends AbstractComponentState {

    /**
     * The <i>tabulator index</i> of the field.
     */
    @NoLayout
    public int tabIndex = 0;

}
