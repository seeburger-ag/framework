/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid;

import java.util.ArrayList;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;

public class GridDefaultSelectionMode extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        final Person person1 = new Person();
        person1.setFirstName("person");
        person1.setLastName("one");

        Person person2 = new Person();
        person2.setFirstName("person");
        person2.setLastName("two");

        ArrayList<Person> items = new ArrayList<Person>();
        items.add(person1);
        items.add(person2);

        final BeanItemContainer<Person> container = new BeanItemContainer<Person>(
                Person.class, items);

        final Grid grid = new Grid();
        grid.setContainerDataSource(container);

        VerticalLayout v = new VerticalLayout();

        v.addComponent(new Button("Deselect on server", new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                grid.select(null);
            }
        }));

        v.addComponent(new Button("Select on server", new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                grid.select(person1);
            }
        }));
        v.addComponent(grid);

        addComponent(v);
    }

    public static class Person {
        private String firstName;
        private String lastName;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }

}
