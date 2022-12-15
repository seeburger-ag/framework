/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.themes.valo;

import com.vaadin.annotations.Theme;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Test UI for image icon in button with 'icon-align-top' style.
 *
 * @author Vaadin Ltd
 */
@Theme("valo")
public class AlignTopIconInButton extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        Button button = new Button();
        button.setIcon(new ThemeResource("../runo/icons/16/document.png"));
        addComponent(button);
        button.addStyleName(ValoTheme.BUTTON_ICON_ALIGN_TOP);
        button.setCaption("caption");
    }

    @Override
    protected Integer getTicketNumber() {
        return 15140;
    }

    @Override
    protected String getTestDescription() {
        return "Icon in the button with 'icon-align-top' style is not "
                + "centered when image is used.";
    }
}
