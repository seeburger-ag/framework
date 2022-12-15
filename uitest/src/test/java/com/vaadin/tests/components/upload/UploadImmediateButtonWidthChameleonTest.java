/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.upload;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

import com.vaadin.ui.themes.*;
import org.junit.Test;

public class UploadImmediateButtonWidthChameleonTest
        extends UploadImmediateButtonWidthTest {

    @Override
    protected String getTheme() {
        return ChameleonTheme.THEME_NAME;
    }

    @Test
    public void immediateButtonWithUndefinedWidth() {
        assertThat(getButtonWidth("upload3"), closeTo(69, 4));
    }
}
