/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.themes;

import java.util.Arrays;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

public class ThemeChangeFavicon extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        for (final String theme : Arrays.asList("valo", "reindeer")) {
            addComponent(new Button(theme, new Button.ClickListener() {
                @Override
                public void buttonClick(ClickEvent event) {
                    setTheme(theme);
                }
            }));
        }
    }

    @Override
    public String getDescription() {
        return "UI for testing that the favicon changes when changing themes";
    }

}
