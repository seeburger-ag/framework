/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.components.textfield;

import com.vaadin.event.FieldEvents;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;

@SuppressWarnings("serial")
public class TextFieldEmptyingPrompt extends AbstractTestUI {

    final TextField textField = new TextField();
    final Label label = new Label();
    final static String RANDOM_PROMPT = "Some prompt here";

    @Override
    public String getTestDescription() {
        return "Type something, then erase it, then click on the button.<br>"
                + "Input prompt should dissapear.<br>";
    }

    @Override
    protected Integer getTicketNumber() {
        return 15144;
    }

    @Override
    protected void setup(VaadinRequest request) {

        addComponent(label);

        textField.setInputPrompt(RANDOM_PROMPT);
        textField.addTextChangeListener(new FieldEvents.TextChangeListener() {

            @Override
            public void textChange(TextChangeEvent event) {
                label.setValue("Textfield value: " + event.getText());
            }
        });
        addComponent(textField);

        Button button = new Button("Click To Remove Prompt");
        button.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {

                textField.setInputPrompt("");
            }
        });
        addComponent(button);
    }
}
