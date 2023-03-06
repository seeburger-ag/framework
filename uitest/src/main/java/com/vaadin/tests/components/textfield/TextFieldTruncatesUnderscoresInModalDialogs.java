/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.components.textfield;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;

@SuppressWarnings("serial")
@Theme("chameleon")
public class TextFieldTruncatesUnderscoresInModalDialogs
        extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        final Window dialog = new Window();

        FormLayout formLayout = new FormLayout();
        formLayout.setSpacing(true);

        formLayout.addComponent(
                new Button("Disappear", new Button.ClickListener() {

                    @Override
                    public void buttonClick(ClickEvent event) {
                        event.getButton().setVisible(false);
                    }
                }));

        formLayout.addComponent(new TextField(null, "____pqjgy____"));

        dialog.setContent(formLayout);

        getUI().addWindow(dialog);
    }

    @Override
    protected String getTestDescription() {
        return "Text field must not truncate underscores in modal dialogs.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 12974;
    }

}
