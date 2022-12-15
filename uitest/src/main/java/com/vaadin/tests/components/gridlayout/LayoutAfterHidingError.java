/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.components.gridlayout;

import com.vaadin.server.UserError;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.DateField;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Panel;

public class LayoutAfterHidingError extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        final Panel panel = new Panel();
        panel.setWidth("300px");
        addComponent(panel);

        GridLayout gl = new GridLayout();
        gl.setWidth("100%");
        panel.setContent(gl);

        final DateField df = new DateField();
        df.setWidth("100%");
        gl.addComponent(df);

        Button err = new Button("Set error");
        err.addClickListener(new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                df.setComponentError(new UserError("foo"));
            }
        });
        gl.addComponent(err);

        err = new Button("Clear error");
        err.addClickListener(new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                df.setComponentError(null);
            }
        });
        gl.addComponent(err);
    }

    @Override
    protected String getTestDescription() {
        return "Setting an error icon for a component in GridLayout and then removing it should properly re-size the component";
    }

    @Override
    protected Integer getTicketNumber() {
        return 12011;
    }

}
