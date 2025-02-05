/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.formlayout;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class FormLayoutResizing extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        FormLayout form1 = createForm("Table", createTable());

        CssLayout cssLayout = new CssLayout(createTable());
        cssLayout.setWidth("100%");
        FormLayout form2 = createForm("Wrap", cssLayout);

        final VerticalLayout view = new VerticalLayout(form1, form2);
        view.setWidth("400px");

        addComponent(view);

        addComponent(new Button("Toggle width", new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                if ((int) view.getWidth() == 400) {
                    view.setWidth("600px");
                } else {
                    view.setWidth("400px");
                }
            }
        }));
    }

    private static FormLayout createForm(String caption, Component table) {
        table.setCaption(caption);

        TextField tf = new TextField("Text field");
        tf.setWidth("100%");

        FormLayout form = new FormLayout();
        form.setWidth("100%");

        form.addComponent(tf);
        form.addComponent(table);
        return form;
    }

    private static Table createTable() {
        Table table = new Table();
        table.setHeight("100px");

        table.addContainerProperty("Column 1", String.class, "");
        table.addContainerProperty("Column 2", String.class, "");
        table.setWidth("100%");
        return table;
    }

    @Override
    protected String getTestDescription() {
        return "100% wide Table inside FormLayout should resize when the layout width changes";
    }

}
