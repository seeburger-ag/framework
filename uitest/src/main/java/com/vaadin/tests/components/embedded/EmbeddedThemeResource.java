/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.embedded;

import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Image;
import com.vaadin.ui.themes.Reindeer;

/**
 * Tests that {@link Embedded} uses correct theme when the theme is set with
 * {@link #setTheme(String)}, and also updates correctly if theme is changed
 * later. {@link Image} is used as the baseline for correct behaviour.
 *
 * @author Vaadin Ltd
 */
public class EmbeddedThemeResource extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        setTheme("tests-components");

        addButton("Toggle theme", new Button.ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                if (Reindeer.THEME_NAME.equals(getTheme())) {
                    setTheme("tests-components");
                } else {
                    setTheme(Reindeer.THEME_NAME);
                }
            }
        });

        // let's show a simple themeresource
        ThemeResource logoResource = new ThemeResource("images/logo.png");
        Embedded embedded = new Embedded("embedded:", logoResource);
        Image image = new Image("image:", logoResource);

        addComponents(embedded, image);
    }

    @Override
    protected String getTestDescription() {
        return "Tests that Embedded updates correctly when using setTheme(String)";
    }

    @Override
    protected Integer getTicketNumber() {
        return 15194;
    }
}
