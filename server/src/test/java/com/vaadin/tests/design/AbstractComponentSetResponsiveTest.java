/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.design;

import org.junit.Test;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Label;

public class AbstractComponentSetResponsiveTest
        extends DeclarativeTestBase<Label> {

    @Test
    public void testResponsiveFlag() {
        Label label = new Label();
        label.setContentMode(ContentMode.HTML);
        label.setResponsive(true);
        String design = "<vaadin-label responsive />";
        testWrite(design, label);
        testRead(design, label);
    }

}
