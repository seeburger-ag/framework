/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.layoutmanager;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;

public class ConcurrentModificationUI extends UI {

    @Override
    protected void init(VaadinRequest request) {
        Panel panel = new Panel();
        setContent(panel);

        FormLayout form = new FormLayout();
        panel.setContent(form);

        HorizontalLayout horizLyt = new HorizontalLayout();
        form.addComponent(horizLyt);

        CssLayout cssLyt = new CssLayout();
        horizLyt.addComponent(cssLyt);
        horizLyt.setComponentAlignment(cssLyt, Alignment.MIDDLE_LEFT);
    }

}
