/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid.basicfeatures.server;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.vaadin.tests.components.grid.basicfeatures.GridBasicFeaturesTest;
import com.vaadin.tests.components.grid.basicfeatures.GridSidebarFeatures;

public class GridSidebarThemeTest extends GridBasicFeaturesTest {

    @Test
    public void testValo() throws Exception {
        runTestSequence("valo");
    }

    @Test
    public void testValoDark() throws Exception {
        runTestSequence("tests-valo-dark");
    }

    @Override
    protected Class<?> getUIClass() {
        return GridSidebarFeatures.class;
    }

    private void runTestSequence(String theme) throws IOException {
        openTestURL("theme=" + theme);

        compareScreen(theme + "-SidebarClosed");
        getSidebarOpenButton().click();

        compareScreen(theme + "-SidebarOpen");

        new Actions(getDriver()).moveToElement(getColumnHidingToggle(2), 5, 5)
                .perform();

        compareScreen(theme + "-OnMouseOverNotHiddenToggle");

        getColumnHidingToggle(2).click();
        getColumnHidingToggle(3).click();
        getColumnHidingToggle(6).click();

        new Actions(getDriver()).moveToElement(getSidebarOpenButton())
                .perform();
        ;

        compareScreen(theme + "-TogglesTriggered");

        new Actions(getDriver()).moveToElement(getColumnHidingToggle(2))
                .perform();
        ;

        compareScreen(theme + "-OnMouseOverHiddenToggle");

        getSidebarOpenButton().click();

        compareScreen(theme + "-SidebarClosed2");
    }
}
