/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.tests.util.Person;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Grid;

public class GridItemSetChange extends AbstractTestUI {

    public static class SneakyBeanContainer extends BeanItemContainer<Person> {

        private Person p = new Person("Foo", "Bar", "", "", "", 0, "");

        public SneakyBeanContainer() throws IllegalArgumentException {
            super(Person.class);
            addItem(p);
        }

        public void reset() {
            internalRemoveAllItems();
            p.setLastName("Baz");
            internalAddItemAtEnd(p, createBeanItem(p), false);
            fireItemSetChange();
        }
    }

    @Override
    protected void setup(VaadinRequest request) {
        final SneakyBeanContainer c = new SneakyBeanContainer();
        Grid g = new Grid(c);
        g.setColumns("firstName", "lastName");
        addComponent(g);
        addComponent(new Button("Reset", new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                c.reset();
            }
        }));
        addComponent(new Button("Modify", new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                c.getItem(c.firstItemId()).getItemProperty("lastName")
                        .setValue("Spam");
            }
        }));
    }

}
