/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.minitutorials.v7_4;

import com.vaadin.data.util.BeanItemContainer;

public class GridExampleHelper {
    public static BeanItemContainer<GridExampleBean> createContainer() {
        BeanItemContainer<GridExampleBean> container = new BeanItemContainer<GridExampleBean>(
                GridExampleBean.class);
        for (int i = 0; i < 1000; i++) {
            container.addItem(new GridExampleBean("Bean " + i, i * i, i / 10d));
        }
        return container;
    }
}
