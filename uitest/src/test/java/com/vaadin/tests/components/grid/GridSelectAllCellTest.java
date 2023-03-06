/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.vaadin.testbench.elements.GridElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

public class GridSelectAllCellTest extends MultiBrowserTest {

    @Override
    public void setup() throws Exception {
        super.setup();

        openTestURL();
    }

    @Test
    public void selectAllCellCanBeClicked() throws IOException {
        GridElement.GridCellElement selectAllCell = $(GridElement.class).first()
                .getHeaderCell(0, 0);

        new Actions(getDriver()).moveToElement(selectAllCell, 2, 2).click()
                .perform();

        WebElement selectAllCheckbox = selectAllCell
                .findElement(By.cssSelector("input"));
        assertThat(selectAllCheckbox.isSelected(), is(true));
    }
}