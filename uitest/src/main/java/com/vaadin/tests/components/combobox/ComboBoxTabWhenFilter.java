/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.combobox;

import com.vaadin.data.Container;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.combobox.FilteringMode;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 * A test case for typing in combo box input field fast plus then press TAB.
 * When type fast and then press tab didn't add new item. Uses SlowComboBox,
 * which has a delay in setVariables method
 */
public class ComboBoxTabWhenFilter extends AbstractTestUI {
    public static final String DESCRIPTION = "Adding new item by typing fast plus then press TAB, very quickly, should add new item and change focus.";

    @Override
    protected void setup(VaadinRequest request) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);
        SlowComboBox comboBox = new SlowComboBox();
        comboBox.setNullSelectionAllowed(false);
        comboBox.setImmediate(true);
        Container container = createContainer();
        comboBox.setContainerDataSource(container);
        comboBox.setNewItemsAllowed(true);
        comboBox.setFilteringMode(FilteringMode.CONTAINS);
        layout.addComponent(comboBox);
        layout.addComponent(new TextField());
    }

    private IndexedContainer createContainer() {
        IndexedContainer container = new IndexedContainer();
        for (int i = 0; i < 100000; ++i) {
            container.addItem("Item " + i);
        }
        return container;
    }

    @Override
    protected String getTestDescription() {
        return DESCRIPTION;
    }

    @Override
    protected Integer getTicketNumber() {
        return 12325;
    }

}
