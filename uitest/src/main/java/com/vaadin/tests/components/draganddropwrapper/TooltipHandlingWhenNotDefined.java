/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.draganddropwrapper;

import com.vaadin.tests.components.TestBase;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.DragAndDropWrapper;
import com.vaadin.ui.DragAndDropWrapper.DragStartMode;
import com.vaadin.ui.Label;

public class TooltipHandlingWhenNotDefined extends TestBase {

    @Override
    protected void setup() {

        CssLayout wrapperLayout = new CssLayout();
        wrapperLayout.setWidth("100%");

        Label label = new Label("Can I has the tooltip?", Label.CONTENT_XHTML);
        label.setId("tooltipLabel");
        label.setDescription("Good! Tooltip works!");
        label.setSizeUndefined();
        wrapperLayout.addComponent(label);

        DragAndDropWrapper wrapper = new DragAndDropWrapper(wrapperLayout);
        wrapper.setWidth("100%");
        wrapper.setDragStartMode(DragStartMode.WRAPPER);

        addComponent(wrapper);

    }

    @Override
    protected String getDescription() {
        return "Wrapper most not prevent child from showing tooltip";
    }

    @Override
    protected Integer getTicketNumber() {
        return 7766;
    }

}
