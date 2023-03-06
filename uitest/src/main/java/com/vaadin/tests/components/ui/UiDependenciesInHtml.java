/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.ui;

import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.StyleSheet;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Label;

@JavaScript("uiDependency.js")
@StyleSheet("theme://uiDependency.css")
@Theme("tests-valo")
public class UiDependenciesInHtml extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        Label statusBox = new Label("Status box");
        statusBox.setId("statusBox");
        addComponent(statusBox);

        getPage().getJavaScript().execute("window.reportUiDependencyStatus();");
    }
}
