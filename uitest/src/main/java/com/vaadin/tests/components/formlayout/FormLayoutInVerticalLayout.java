/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.formlayout;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Test UI for H2 label inside FormLayout.
 *
 * @author Vaadin Ltd
 */
@Theme("valo")
public class FormLayoutInVerticalLayout extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        CssLayout container = new CssLayout();
        addComponent(container);

        FormLayout formLayout = new FormLayout();

        Label sectionLabel = createLabel();
        formLayout.addComponent(sectionLabel);

        TextField nameTextField = new TextField("Name");
        nameTextField.setValue("Lorem ipsum");
        nameTextField.setWidth("50%");
        formLayout.addComponent(nameTextField);

        container.addComponent(formLayout);
        container.addComponent(createLabel());
    }

    @Override
    protected Integer getTicketNumber() {
        return super.getTicketNumber();
    }

    @Override
    protected String getTestDescription() {
        return "FormLayout 'margin-top' value should take precedence over "
                + "the rule defined in any other selector.";
    }

    private Label createLabel() {
        Label sectionLabel = new Label("Personal info");
        sectionLabel.addStyleName(ValoTheme.LABEL_H2);
        sectionLabel.addStyleName(ValoTheme.LABEL_COLORED);
        return sectionLabel;
    }
}
