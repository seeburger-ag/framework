/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.design.designroot;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

public class ExtendedDesignWithEmptyAnnotationUI extends UI {

    @Override
    protected void init(VaadinRequest request) {
        setContent(new ExtendedDesignWithEmptyAnnotation());

    }

}
