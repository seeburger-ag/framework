/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.gridlayout;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;

public class GridLayoutScrollPosition extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {

        Panel panel = new Panel();
        setContent(panel);

        GridLayout gridLayout = new GridLayout();
        gridLayout.setWidth("500px");
        panel.setContent(gridLayout);
        gridLayout.setColumns(1);
        gridLayout.setRows(1);

        Label dummyLabel = new Label("Dummy");
        dummyLabel.setHeight("500px");
        gridLayout.addComponent(dummyLabel);

        final CheckBox visibilityToggleCheckBox = new CheckBox(
                "Hide / Show toggleable components");
        visibilityToggleCheckBox.setId("visibility-toggle");
        visibilityToggleCheckBox.setHeight("2000px");
        visibilityToggleCheckBox.setImmediate(true);
        visibilityToggleCheckBox.setValue(false); // Initially unchecked
        gridLayout.addComponent(visibilityToggleCheckBox);

        final Label toggleableLabel = new Label("Toggleable Label");
        toggleableLabel.setHeight("2000px");
        toggleableLabel.setVisible(false); // Initially hidden
        gridLayout.addComponent(toggleableLabel);

        visibilityToggleCheckBox
                .addValueChangeListener(new ValueChangeListener() {
                    @Override
                    public void valueChange(ValueChangeEvent event) {
                        toggleableLabel.setVisible(
                                visibilityToggleCheckBox.getValue());
                    }
                });

    }

    @Override
    protected String getTestDescription() {
        return "The UI scroll position should not be reset when visibility of GridLayout children is toggled";
    }

    @Override
    protected Integer getTicketNumber() {
        return 13386;
    }
}