/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.layouts.layouttester;

import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.AbstractLayout;
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
public class BaseLayoutForSpacingMargin extends BaseLayoutTestUI {
    /**
     * @param layoutClass
     */
    public BaseLayoutForSpacingMargin(
            Class<? extends AbstractLayout> layoutClass) {
        super(layoutClass);
    }

    @Override
    protected void setup(VaadinRequest request) {
        init();
        buildLayout();
        super.setup(request);
    }

    private void buildLayout() {
        Table t1 = getTestTable();
        Table t2 = getTestTable();
        l2.addComponent(t1);
        l2.setMargin(false);
        l2.setSpacing(false);
        // Must add something around the hr to avoid the margins collapsing
        l2.addComponent(new Label(
                "<div style='height: 1px'></div><hr /><div style='height: 1px'></div>",
                ContentMode.HTML));
        l2.addComponent(t2);
        final Button btn1 = new Button("Toggle margin on/off");
        btn1.addClickListener(new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                boolean margin = l2.getMargin().hasLeft();
                l2.setMargin(!margin);

            }
        });
        final Button btn2 = new Button("Toggle spacing on/off");
        btn2.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                l2.setSpacing(!l2.isSpacing());
            }
        });
        l1.addComponent(btn1);
        l1.addComponent(btn2);
    }
}
