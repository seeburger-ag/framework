/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests;

import java.util.Random;

import com.vaadin.data.Item;
import com.vaadin.ui.AbstractSelect;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Select;
import com.vaadin.ui.VerticalLayout;

public class UsingCustomNewItemHandlerInSelect extends CustomComponent {

    private final Select select = new Select();

    public static Random random = new Random(1);

    private static int sequence = 0;

    public UsingCustomNewItemHandlerInSelect() {

        VerticalLayout pl = new VerticalLayout();
        pl.setMargin(true);
        final Panel panel = new Panel("Select demo", pl);
        pl.addComponent(select);

        select.setCaption("Select component");
        select.setImmediate(true);
        select.addContainerProperty("CAPTION", String.class, "");
        select.setItemCaptionMode(Select.ITEM_CAPTION_MODE_PROPERTY);
        select.setItemCaptionPropertyId("CAPTION");
        select.setNewItemsAllowed(true);
        select.setNewItemHandler(new MyNewItemHandler());

        populateSelect();

        setCompositionRoot(panel);
    }

    public void populateSelect() {
        final String[] names = new String[] { "John", "Mary", "Joe", "Sarah",
                "Jeff", "Jane", "Peter", "Marc", "Josie", "Linus" };
        for (int j = 0; j < 4; j++) {
            Integer id = new Integer(sequence++);
            Item item = select.addItem(id);
            item.getItemProperty("CAPTION").setValue(id.toString() + ": "
                    + names[random.nextInt() % names.length]);
        }
    }

    public class MyNewItemHandler implements AbstractSelect.NewItemHandler {
        @Override
        public void addNewItem(String newItemCaption) {
            // here could be db insert or other backend operation
            Integer id = new Integer(sequence++);
            Item item = select.addItem(id);
            item.getItemProperty("CAPTION")
                    .setValue(id.toString() + ": " + newItemCaption);
            select.setValue(id);
        }

    }

}
