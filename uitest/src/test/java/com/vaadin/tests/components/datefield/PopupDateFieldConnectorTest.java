/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.datefield;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

import com.vaadin.testbench.elements.DateFieldElement;
import com.vaadin.testbench.elements.PopupDateFieldElement;
import com.vaadin.tests.tb3.SingleBrowserTest;

public class PopupDateFieldConnectorTest extends SingleBrowserTest {

    @Test
    public void popupDateFieldElementIsLocated() {
        openTestURL();

        assertThat($(PopupDateFieldElement.class).all().size(), is(1));
        assertThat($(DateFieldElement.class).all().size(), is(2));
    }
}