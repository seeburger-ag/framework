/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.server.componentcontainer;

import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Layout;

public class CssLayoutTest extends AbstractIndexedLayoutTestBase {

    @Override
    protected Layout createLayout() {
        return new CssLayout();
    }

    @Override
    public CssLayout getLayout() {
        return (CssLayout) super.getLayout();
    }

    @Override
    protected Component getComponent(int index) {
        return getLayout().getComponent(index);
    }

    @Override
    protected int getComponentIndex(Component c) {
        return getLayout().getComponentIndex(c);
    }

    @Override
    protected int getComponentCount() {
        return getLayout().getComponentCount();
    }

}
