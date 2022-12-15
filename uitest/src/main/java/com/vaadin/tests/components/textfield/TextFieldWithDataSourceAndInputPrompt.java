/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.textfield;

import com.vaadin.data.util.BeanItem;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.TextField;

public class TextFieldWithDataSourceAndInputPrompt extends AbstractTestUI {
    public static class Pojo {
        private String string;

        public String getString() {
            return string;
        }

        public void setString(String string) {
            this.string = string;
        }
    }

    @Override
    protected void setup(VaadinRequest request) {
        TextField textField = new TextField("TextField with null value");
        textField.setInputPrompt("Me is input prompt");
        textField.setNullRepresentation(null);
        textField.setValue(null);
        addComponent(textField);

        TextField textField2 = new TextField(
                "TextField with null data source value");
        textField2.setInputPrompt("Me is input prompt");
        textField2.setNullRepresentation(null);
        BeanItem<Pojo> beanItem = new BeanItem<Pojo>(new Pojo());
        textField2.setPropertyDataSource(beanItem.getItemProperty("string"));
        addComponent(textField2);
    }

    @Override
    protected String getTestDescription() {
        return "Input prompt should be shown when data source provides null";
    }

    @Override
    protected Integer getTicketNumber() {
        return 11021;
    }

}
