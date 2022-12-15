/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.panel;

import com.vaadin.tests.components.AbstractComponentTest;
import com.vaadin.ui.Panel;

public class PanelTest<T extends Panel> extends AbstractComponentTest<T> {

    @SuppressWarnings("unchecked")
    @Override
    protected Class<T> getTestClass() {
        return (Class<T>) Panel.class;
    }

}
