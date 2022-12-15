/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.declarative;

import com.vaadin.annotations.DesignRoot;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.declarative.Design;

@DesignRoot
public class PotusForm extends VerticalLayout {

    @PropertyId("firstName")
    public TextField firstName;
    @PropertyId("lastName")
    public TextField lastName;
    @PropertyId("party")
    public ComboBox party;
    @PropertyId("tookOffice")
    public PopupDateField tookOffice;
    @PropertyId("leftOffice")
    public PopupDateField leftOffice;

    public Button save;
    public Button revert;
    public Button delete;

    public PotusForm() {
        Design.read(this);
        party.addItems("Democratic Party");
        party.addItems("Republican Party");
        party.addItems("Independent");
    }
}
