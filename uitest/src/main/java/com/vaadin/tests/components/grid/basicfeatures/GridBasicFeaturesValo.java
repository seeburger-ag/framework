/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid.basicfeatures;

import com.vaadin.annotations.Theme;
import com.vaadin.ui.themes.ValoTheme;

@Theme(ValoTheme.THEME_NAME)
public class GridBasicFeaturesValo extends GridBasicFeatures {
    @Override
    @Deprecated
    public String getTheme() {
        return ValoTheme.THEME_NAME;
    }
}
