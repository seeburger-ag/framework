/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.tooltip;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

import org.junit.Test;
import org.openqa.selenium.By;

import com.vaadin.testbench.elements.MenuBarElement;
import com.vaadin.tests.tb3.MultiBrowserTest;
import com.vaadin.ui.themes.ChameleonTheme;
import com.vaadin.ui.themes.Reindeer;
import com.vaadin.ui.themes.Runo;
import com.vaadin.ui.themes.ValoTheme;

public class MenuBarTooltipTest extends MultiBrowserTest {

    @Test
    public void toolTipShouldBeOnTopOfMenuItem() {
        String[] themes = new String[] { ValoTheme.THEME_NAME,
                Reindeer.THEME_NAME, Runo.THEME_NAME,
                ChameleonTheme.THEME_NAME };

        for (String theme : themes) {
            assertZIndices(theme);
        }
    }

    public void assertZIndices(String theme) {
        openTestURL("theme=" + theme);

        $(MenuBarElement.class).first().clickItem("Menu item");

        assertThat(String.format("Invalid z-index for theme %s.", theme),
                getZIndex("v-tooltip"),
                greaterThan(getZIndex("v-menubar-popup")));
    }

    private int getZIndex(String className) {
        return Integer.parseInt(
                findElement(By.className(className)).getCssValue("z-index"));
    }

}