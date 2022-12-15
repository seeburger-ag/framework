/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.tests.util.PersonContainer;
import com.vaadin.ui.Grid;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;

public class GridEditorUI extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        PersonContainer container = PersonContainer.createWithTestData();

        addComponent(createGrid(container));
    }

    protected Grid createGrid(PersonContainer container) {
        Grid grid = new Grid(container);

        // Don't use address since there's no converter
        grid.removeColumn("address");

        grid.setEditorEnabled(true);

        grid.getColumn("firstName").setEditorField(new PasswordField());

        TextField lastNameField = (TextField) grid.getColumn("lastName")
                .getEditorField();
        lastNameField.setMaxLength(50);

        grid.getColumn("phoneNumber").getEditorField().setReadOnly(true);

        return grid;
    }

}
