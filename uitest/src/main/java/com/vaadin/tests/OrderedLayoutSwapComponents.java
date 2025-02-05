/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests;

import java.util.ArrayList;

import com.vaadin.ui.AbstractOrderedLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * This Component contains some simple test to see that component updates its
 * contents propertly.
 *
 * @author Vaadin Ltd.
 */
public class OrderedLayoutSwapComponents extends CustomComponent {

    private final AbstractOrderedLayout main;

    ArrayList<MyComponent> order = new ArrayList<MyComponent>();

    public OrderedLayoutSwapComponents() {

        main = new VerticalLayout();
        // main.setSizeFull();
        setCompositionRoot(main);
        createNewView();
    }

    public void createNewView() {
        main.removeAllComponents();

        for (int i = 0; i < 10; i++) {
            MyComponent c = new MyComponent("Component " + i);
            main.addComponent(c);
            order.add(c);
        }
        setCompositionRoot(main);

    }

    class MyComponent extends CustomComponent {

        private static final int FIRST = 0;
        private static final int LAST = 1;
        private Button up;
        private Button down;

        MyComponent(String name) {
            HorizontalLayout ol = new HorizontalLayout();
            ol.setId(name.replaceAll(" ", ""));
            ol.addComponent(new Label(name));
            up = new Button("up");
            up.addListener(new Button.ClickListener() {
                @Override
                public void buttonClick(ClickEvent event) {
                    int newIndex = order.indexOf(MyComponent.this) - 1;
                    MyComponent old = order.get(newIndex);
                    main.replaceComponent(old, MyComponent.this);
                    order.remove(MyComponent.this);
                    order.add(newIndex, MyComponent.this);
                    if (newIndex == 0) {
                        MyComponent.this.setMode(FIRST);
                    } else {
                        MyComponent.this.setMode(69);
                    }
                }
            });
            ol.addComponent(up);

            down = new Button("down");
            down.addListener(new Button.ClickListener() {
                @Override
                public void buttonClick(ClickEvent event) {
                    int newIndex = order.indexOf(MyComponent.this) + 1;
                    MyComponent old = order.get(newIndex);
                    main.replaceComponent(old, MyComponent.this);
                    order.remove(MyComponent.this);
                    order.add(newIndex, MyComponent.this);
                    if (newIndex == order.size() - 1) {
                        MyComponent.this.setMode(LAST);
                    } else {
                        MyComponent.this.setMode(69);
                    }
                }
            });
            ol.addComponent(down);

            setCompositionRoot(ol);

        }

        public void setMode(int mode) {
            up.setEnabled(true);
            down.setEnabled(true);
            if (mode == FIRST) {
                up.setEnabled(false);
            } else if (mode == LAST) {
                down.setEnabled(false);
            }
        }
    }

}
