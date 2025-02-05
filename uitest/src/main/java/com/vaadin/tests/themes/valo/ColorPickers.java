/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.themes.valo;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.colorpicker.Color;
import com.vaadin.ui.AbstractColorPicker.PopupStyle;
import com.vaadin.ui.ColorPicker;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class ColorPickers extends VerticalLayout implements View {
    public ColorPickers() {
        setMargin(true);

        Label h1 = new Label("Color Pickers");
        h1.addStyleName(ValoTheme.LABEL_H1);
        addComponent(h1);

        HorizontalLayout row = new HorizontalLayout();
        row.addStyleName(ValoTheme.LAYOUT_HORIZONTAL_WRAPPING);
        row.setSpacing(true);
        addComponent(row);

        TestIcon testIcon = new TestIcon(40);

        ColorPicker cp = new ColorPicker();
        cp.setDefaultCaptionEnabled(true);
        cp.setIcon(testIcon.get());
        cp.setColor(new Color(138, 73, 115));
        row.addComponent(cp);

        cp = new ColorPicker();
        cp.setPopupStyle(PopupStyle.POPUP_SIMPLE);
        cp.setTextfieldVisibility(true);
        row.addComponent(cp);
    }

    @Override
    public void enter(ViewChangeEvent event) {
        // TODO Auto-generated method stub

    }

}
