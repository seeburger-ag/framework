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
import java.util.Collection;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.data.bean.Person;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Grid;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class InitiallyDisabledGrid extends UI {

    @Override
    protected void init(VaadinRequest request) {
        VerticalLayout layout = new VerticalLayout();
        setContent(layout);
        layout.setSizeFull();
        layout.setWidth("600px");
        layout.setHeight("600px");
        final Grid grid = createGrid();
        Button button = new Button("Enable/Disable", new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                grid.setEnabled(!grid.isEnabled());
            }
        });

        layout.addComponent(button);
        VerticalLayout l = new VerticalLayout();
        l.setSizeFull();
        l.addComponent(grid);

        layout.addComponent(l);
        layout.setExpandRatio(l, 1.0f);
    }

    private Grid createGrid() {
        // Have some data
        Collection<Person> people = new ArrayList<Person>();
        for (int i = 0; i < 100; i++) {
            Person person = new Person();
            person.setFirstName("First " + i);
            person.setLastName("Last " + i);
            people.add(person);

        }
        // Have a container of some type to contain the data
        BeanItemContainer<Person> container = new BeanItemContainer<Person>(
                Person.class, people);

        // Create a grid bound to the container
        Grid grid = new Grid(container);
        grid.setSizeFull();
        grid.setColumns("firstName", "lastName");

        grid.setEnabled(false);

        return grid;

    }

}