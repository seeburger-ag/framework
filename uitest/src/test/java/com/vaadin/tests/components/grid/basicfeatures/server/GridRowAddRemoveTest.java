/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid.basicfeatures.server;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.testbench.elements.NotificationElement;
import com.vaadin.tests.components.grid.basicfeatures.GridBasicFeaturesTest;

public class GridRowAddRemoveTest extends GridBasicFeaturesTest {

    @Test
    public void addRows_loadAllAtOnce() {
        setDebug(true);
        openTestURL();

        selectMenuPath("Settings", "Clear log");
        selectMenuPath("Component", "Body rows", "Remove all rows");
        selectMenuPath("Component", "Body rows", "Add 18 rows");

        Assert.assertTrue(
                "All added rows should be fetched in the same round trip.",
                logContainsText("Requested items 0 - 18"));
    }

    @Test
    public void testAdd18Rows() {
        setDebug(true);
        openTestURL();

        selectMenuPath("Settings", "Clear log");
        selectMenuPath("Component", "Body rows", "Add 18 rows");

        Assert.assertFalse("An error notification is present.",
                isElementPresent(NotificationElement.class));
    }
}
