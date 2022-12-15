/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.combobox;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Label;

public class ComboBoxPopupWhenBodyScrolls extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        getPage().getStyles()
                .add("body.v-generated-body { overflow: auto;height:auto;}");
        getPage().getStyles().add(
                "body.v-generated-body .v-ui.v-scrollable{ overflow: visible;height:auto !important;}");
        ComboBox cb = new ComboBox();
        for (int i = 0; i < 10; i++) {
            cb.addItem("Item " + i);
        }

        Label spacer = new Label("foo");
        spacer.setHeight("2000px");
        addComponent(spacer);
        addComponent(cb);
        spacer = new Label("foo");
        spacer.setHeight("2000px");
        addComponent(spacer);
        // Chrome requires document.scrollTop (<body>)
        // Firefox + IE wants document.documentElement.scrollTop (<html>)
        getPage().getJavaScript().execute(
                "document.body.scrollTop=1800;document.documentElement.scrollTop=1800;");
    }
}
