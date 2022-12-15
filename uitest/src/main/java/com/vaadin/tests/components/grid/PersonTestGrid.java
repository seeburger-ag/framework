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
import com.vaadin.tests.fieldgroup.ComplexPerson;
import com.vaadin.ui.Grid;

public class PersonTestGrid extends Grid {

    public PersonTestGrid(int size) {
        BeanItemContainer<ComplexPerson> container = ComplexPerson
                .createContainer(size);
        container.addNestedContainerBean("address");
        setContainerDataSource(container);
    }
}
