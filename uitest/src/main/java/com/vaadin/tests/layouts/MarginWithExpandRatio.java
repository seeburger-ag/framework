/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.layouts;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.tests.util.TestUtils;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class MarginWithExpandRatio extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        TestUtils.injectCSS(this,
                ".hugemargin { margin: 10px 20px !important; }");

        HorizontalLayout hl = new HorizontalLayout();
        addLayoutTest(hl);
        hl.setExpandRatio(hl.getComponent(0), 1.0f);
        hl.setExpandRatio(hl.getComponent(2), 0.5f);
        VerticalLayout vl = new VerticalLayout();
        addLayoutTest(vl);
        vl.setExpandRatio(vl.getComponent(0), 1.0f);
        vl.setExpandRatio(vl.getComponent(2), 0.5f);

        GridLayout gl = new GridLayout(2, 1);
        addLayoutTest(gl);
        gl.setColumnExpandRatio(0, 1.0f);
        gl.setRowExpandRatio(0, 1.0f);
        gl.setColumnExpandRatio(1, 0.5f);
        gl.setRowExpandRatio(1, 0.5f);
    }

    @Override
    protected String getTestDescription() {
        return "Layout content overflows if CSS margin used with expand ratio";
    }

    @Override
    protected Integer getTicketNumber() {
        return 11553;
    }

    private void addLayoutTest(Layout l) {
        l.setSizeFull();

        Label lbl = new Label("First (expand ratio 1)");
        lbl.setSizeUndefined();
        l.addComponent(lbl);

        lbl = new Label("Second (margin 10px)");
        lbl.setSizeUndefined();
        lbl.addStyleName("hugemargin");
        l.addComponent(lbl);

        lbl = new Label("Third (margin+xr)");
        lbl.setSizeUndefined();
        lbl.addStyleName("hugemargin");
        l.addComponent(lbl);

        Panel p = new Panel(l.getClass().getSimpleName(), l);
        p.setWidth("600px");
        p.setHeight("200px");
        addComponent(p);
    }
}
