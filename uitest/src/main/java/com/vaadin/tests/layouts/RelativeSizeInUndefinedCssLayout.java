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
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;

public class RelativeSizeInUndefinedCssLayout extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        getPage().getStyles().add(".css-style { width: 520px; }");

        CssLayout cssLayout = new CssLayout();
        cssLayout.addStyleName("css-style");

        setContent(cssLayout);

        FormLayout formLayout = new FormLayout();
        formLayout.setSizeFull();

        cssLayout.addComponent(formLayout);

        TextField tf = new TextField("Enter something");
        tf.setWidth("100%");
        formLayout.addComponent(tf);

    }

}
