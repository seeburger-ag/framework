/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.slider;

import com.vaadin.shared.AbstractFieldState;
import com.vaadin.shared.annotations.NoLayout;

public class SliderState extends AbstractFieldState {
    {
        primaryStyleName = "v-slider";
    }

    @NoLayout
    public double value;

    @NoLayout
    public double maxValue = 100;
    @NoLayout
    public double minValue = 0;

    /**
     * The number of fractional digits that are considered significant. Must be
     * non-negative.
     */
    @NoLayout
    public int resolution = 0;

    public SliderOrientation orientation = SliderOrientation.HORIZONTAL;

}
