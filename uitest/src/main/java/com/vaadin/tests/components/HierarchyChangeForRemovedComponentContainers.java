/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

public class HierarchyChangeForRemovedComponentContainers extends TestBase {

    private HorizontalLayout mainContent;
    private VerticalLayout lo2;

    @Override
    protected void setup() {

        mainContent = new HorizontalLayout();
        mainContent.setSizeFull();

        lo2 = new VerticalLayout();
        Button button1 = new Button("asdasd1");
        button1.setHeight("90%");
        Button button2 = new Button("asdasd2");
        button2.setHeight("90%");
        lo2.addComponent(button1);
        lo2.addComponent(button2);

        compose();

        addComponent(new Button("Replace layout with button",
                new Button.ClickListener() {
                    @Override
                    public void buttonClick(ClickEvent event) {
                        compose2();
                    }
                }));
    }

    private void compose() {
        getLayout().removeAllComponents();
        getLayout().addComponent(mainContent);
        mainContent.addComponent(lo2);
        System.out.println("composed");
    }

    private void compose2() {
        getLayout().removeAllComponents();
        getLayout().addComponent(lo2);
    }

    @Override
    protected String getDescription() {
        return "HierarchyChange events should be triggered for removed layouts";
    }

    @Override
    protected Integer getTicketNumber() {
        return 9815;
    }

}
