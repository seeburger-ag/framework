/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.textfield;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.TextFieldElement;
import com.vaadin.tests.tb3.MultiBrowserTest;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LocaleChangeOnReadOnlyFieldTest extends MultiBrowserTest {

    @Test
    public void localeIsChangedOnReadOnlyField() {
        openTestURL();

        TextFieldElement textField = $(TextFieldElement.class).first();
        assertThat(textField.getValue(), is("1,024,000"));

        $(ButtonElement.class).caption("Change Locale").first().click();
        assertThat(textField.getValue(), is("1.024.000"));
    }

}