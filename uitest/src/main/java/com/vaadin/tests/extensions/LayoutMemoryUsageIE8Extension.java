/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.extensions;

import com.vaadin.server.AbstractExtension;
import com.vaadin.ui.UI;

/**
 * Test extension for finding out the size of the measuredSizes map of
 * LayoutManagerIE8.
 *
 * This UI extension uses JSNI to register a JavaScript method
 * window.vaadin.getMeasuredSizesCount() that can be used to query the size of
 * the internal map of the layout manager. It should only be used on IE8.
 *
 * @since 7.1.13
 * @author Vaadin Ltd
 */
public class LayoutMemoryUsageIE8Extension extends AbstractExtension {
    public void extend(UI target) {
        super.extend(target);
    }
}
