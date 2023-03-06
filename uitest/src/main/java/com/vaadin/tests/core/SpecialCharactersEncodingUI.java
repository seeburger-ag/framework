/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.core;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.TextField;

public class SpecialCharactersEncodingUI extends AbstractTestUI {

    public static String textWithZwnj = "\ufeffछुट्‌याउनेछन्  क्ष  क्‌ष  क्‍ष";

    @Override
    protected void setup(VaadinRequest request) {
        MenuBar menubar = new MenuBar();
        menubar.setId("menubar");
        addComponent(menubar);
        menubar.addItem(textWithZwnj, null);

        Label label = new Label(textWithZwnj);
        label.setId("label");
        addComponent(label);

        TextField f = new TextField("Textfield", textWithZwnj);
        f.setId("textfield");
        addComponent(f);

    }

}
