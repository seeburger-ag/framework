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
import java.util.List;
import java.util.Random;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.tests.fieldgroup.ComplexPerson;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Grid;

public class GridDataSourceReset extends AbstractTestUI {

    BeanItemContainer<ComplexPerson> container;
    List<ComplexPerson> persons;
    Grid grid;

    @Override
    protected void setup(VaadinRequest request) {
        persons = createPersons(10, new Random(1));
        container = new BeanItemContainer<ComplexPerson>(ComplexPerson.class,
                persons);

        grid = new Grid(container);
        grid.select(container.firstItemId());
        addComponent(new Button("Remove first", new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                container.removeAllItems();
                persons.remove(0);

                container.addAll(persons);
                grid.select(container.firstItemId());
            }
        }));
        addComponent(grid);
    }

    public static List<ComplexPerson> createPersons(int count, Random r) {
        List<ComplexPerson> c = new ArrayList<ComplexPerson>();
        for (int i = 0; i < count; ++i) {
            c.add(ComplexPerson.create(r));
        }
        return c;
    }
}
