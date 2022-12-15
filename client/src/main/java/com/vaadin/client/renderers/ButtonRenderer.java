/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.renderers;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.ui.Button;
import com.vaadin.client.widget.grid.RendererCellReference;

/**
 * A Renderer that displays buttons with textual captions. The values of the
 * corresponding column are used as the captions. Click handlers can be added to
 * the renderer, invoked when any of the rendered buttons is clicked.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public class ButtonRenderer extends ClickableRenderer<String, Button> {

    @Override
    public Button createWidget() {
        Button b = GWT.create(Button.class);
        b.addClickHandler(this);
        b.setStylePrimaryName("v-nativebutton");
        return b;
    }

    @Override
    public void render(RendererCellReference cell, String text, Button button) {
        button.setText(text);
    }
}
