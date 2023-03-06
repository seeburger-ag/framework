/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.combobox;

import com.vaadin.data.Item;
import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.tests.components.TestBase;
import com.vaadin.ui.ComboBox;

public class PopUpWidth extends TestBase {

    @Override
    protected void setup() {

        addComponent(createComboBox("Do not touch this"));
        addComponent(createComboBox(
                "Browse this (check that width does not change)"));
    }

    private ComboBox createComboBox(String caption) {
        ComboBox cb = new ComboBox(caption);
        cb.addContainerProperty("caption", String.class, null);
        cb.addContainerProperty("icon", Resource.class, null);
        for (int i = 1; i < 200 + 1; i++) {
            Item item = cb.addItem(i);
            item.getItemProperty("caption").setValue("Item " + i);
            item.getItemProperty("icon")
                    .setValue(new ThemeResource("../runo/icons/16/users.png"));
        }
        cb.setItemIconPropertyId("icon");
        cb.setItemCaptionPropertyId("caption");
        return cb;
    }

    @Override
    protected String getDescription() {
        return "Check that width of popup or combobox does not change when paging.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 7013;
    }

}
