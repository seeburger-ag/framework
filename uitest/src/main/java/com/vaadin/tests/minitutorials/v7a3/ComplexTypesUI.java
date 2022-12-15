/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.minitutorials.v7a3;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

public class ComplexTypesUI extends UI {

    @Override
    protected void init(VaadinRequest request) {
        ComplexTypesComponent complexTypesComponent = new ComplexTypesComponent();
        complexTypesComponent.sendComplexTypes();
        setContent(complexTypesComponent);
    }

}
