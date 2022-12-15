/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.combobox;

import com.vaadin.data.util.BeanContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.AbstractSelect.ItemCaptionMode;

/**
 * Test for issue #11246 where ComboBox set to render from Property does not
 * filter correctly when page size is 0
 * 
 * @since
 * @author Vaadin Ltd
 */
public class ComboboxPageLengthZeroFilter extends AbstractTestUI {

    public static class Topping {
        private int id;
        private String name;

        public Topping(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    @Override
    protected void setup(VaadinRequest request) {
        BeanContainer<Integer, Topping> container = new BeanContainer<Integer, Topping>(
                Topping.class);
        container.setBeanIdProperty("id");
        for (int i = 0; i < 12; i++) {
            container.addBean(new Topping(i, "Toping " + i));
        }

        final ComboBox comboBox = new ComboBox();
        comboBox.setPageLength(0);
        comboBox.setItemCaptionMode(ItemCaptionMode.PROPERTY);
        comboBox.setItemCaptionPropertyId("name");
        comboBox.setContainerDataSource(container);
        comboBox.setInvalidAllowed(false);
        comboBox.setNullSelectionAllowed(false);
        comboBox.setTextInputAllowed(true);

        getLayout().addComponent(comboBox);
    }

}
