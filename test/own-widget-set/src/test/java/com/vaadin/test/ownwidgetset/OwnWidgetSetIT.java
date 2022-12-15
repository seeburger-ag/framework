/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.test.ownwidgetset;

import org.junit.Test;

import com.vaadin.test.defaultwidgetset.AbstractWidgetSetIT;

public class OwnWidgetSetIT extends AbstractWidgetSetIT {

    @Test
    public void appStartsUserCanInteract() {
        testAppStartsUserCanInteract(
                "com.vaadin.test.ownwidgetset.OwnWidgetSet");
    }
}
