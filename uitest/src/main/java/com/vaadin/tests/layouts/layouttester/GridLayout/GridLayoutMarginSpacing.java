/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.layouts.layouttester.GridLayout;

import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;

/**
 *
 * @since
 * @author Vaadin Ltd
 */
public class GridLayoutMarginSpacing extends GridBaseLayoutTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        buildLayout();
        super.setup(request);
    }

    private void buildLayout() {
        Table t1 = getTestTable();
        Table t2 = getTestTable();
        t1.setSizeUndefined();
        t2.setSizeUndefined();

        final Button btn1 = new Button("Toggle margin on/off");
        btn1.addClickListener(new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                boolean margin = layout.getMargin().hasLeft();
                layout.setMargin(!margin);

            }
        });
        final Button btn2 = new Button("Toggle spacing on/off");
        btn2.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                layout.setSpacing(!layout.isSpacing());
            }
        });
        layout.addComponent(btn1);
        layout.addComponent(btn2);

        layout.addComponent(t1);
        layout.setMargin(false);
        layout.setSpacing(false);
        // Must add something around the hr to avoid the margins collapsing
        layout.addComponent(new Label(
                "<div style='height: 1px'></div><hr /><div style='height: 1px'></div>",
                ContentMode.HTML));
        layout.addComponent(t2);
    }
}
