/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid;

import com.vaadin.tests.widgetset.client.SimpleTestBean;
import com.vaadin.ui.Grid.AbstractRenderer;

public class BeanRenderer extends AbstractRenderer<SimpleTestBean> {
    public BeanRenderer() {
        super(SimpleTestBean.class, "");
    }
}
