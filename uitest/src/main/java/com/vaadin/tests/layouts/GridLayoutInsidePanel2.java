/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.layouts;

import com.vaadin.server.LegacyApplication;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.LegacyWindow;

public class GridLayoutInsidePanel2 extends LegacyApplication {

    private Layout layout;

    @Override
    public void init() {
        LegacyWindow w = new LegacyWindow("Main");
        setMainWindow(w);
        layout = (Layout) w.getContent();
        GridLayout gl = new GridLayout(1, 1);
        gl.setSizeUndefined();
        Label l = new Label("This should be visible");
        l.setWidth("100px");
        gl.addComponent(l);

        layout.setSizeUndefined();
        layout.addComponent(gl);
    }

}
