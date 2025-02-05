/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests;

import java.util.Date;
import java.util.Vector;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

public class StressComponentsInTable extends CustomComponent {

    public StressComponentsInTable() {
        final VerticalLayout main = new VerticalLayout();
        setCompositionRoot(main);

        main.addComponent(getTestTable(4, 1000));

    }

    public static Table getTestTable(int cols, int rows) {
        final Table t = new Table();
        t.setColumnCollapsingAllowed(true);
        for (int i = 0; i < cols; i++) {
            t.addContainerProperty(testString[i], String.class, "");
        }
        t.addContainerProperty("button", Button.class, null);
        for (int i = 0; i < rows; i++) {
            final Vector<Object> content = new Vector<Object>();
            for (int j = 0; j < cols; j++) {
                content.add(rndString());
            }
            content.add(new Button("b" + i, new Button.ClickListener() {

                @Override
                public void buttonClick(ClickEvent event) {
                    Button b = event.getButton();
                    System.out.println(b.getCaption() + " click: "
                            + (new Date()).toString());
                    System.out.println(b.getUI().getSession());

                }
            }));
            t.addItem(content.toArray(), "" + i);
        }
        t.setRowHeaderMode(Table.ROW_HEADER_MODE_ID);
        return t;
    }

    static String[] testString = new String[] { "Jacob", "Michael", "Joshua",
            "Matthew", "Ethan", "Andrew", "Daniel", "Anthony", "Christopher",
            "Joseph", "William", "Alexander", "Ryan", "David", "Nicholas",
            "Tyler", "James", "John", "Jonathan", "Nathan", "Samuel",
            "Christian", "Noah", "Dylan", "Benjamin", "Logan", "Brandon",
            "Gabriel", "Zachary", "Jose", "Elijah", "Angel", "Kevin", "Jack",
            "Caleb", "Justin", "Austin", "Evan", "Robert", "Thomas", "Luke",
            "Mason", "Aidan", "Jackson", "Isaiah", "Jordan", "Gavin", "Connor",
            "Aiden", "Isaac", "Jason", "Cameron", "Hunter", "Jayden", "Juan",
            "Charles", "Aaron", "Lucas", "Luis", "Owen", "Landon", "Diego",
            "Brian", "Adam", "Adrian", "Kyle", "Eric", "Ian", "Nathaniel",
            "Carlos", "Alex", "Bryan", "Jesus", "Julian", "Sean", "Carter",
            "Hayden", "Jeremiah", "Cole", "Brayden", "Wyatt", "Chase", "Steven",
            "Timothy", "Dominic", "Sebastian", "Xavier", "Jaden", "Jesse",
            "Devin", "Seth", "Antonio", "Richard", "Miguel", "Colin", "Cody",
            "Alejandro", "Caden", "Blake", "Carson" };

    public static String rndString() {
        return testString[(int) (Math.random() * testString.length)];
    }

}
