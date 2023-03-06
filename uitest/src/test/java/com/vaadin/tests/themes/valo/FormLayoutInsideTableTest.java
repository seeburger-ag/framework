/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.themes.valo;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.vaadin.tests.tb3.MultiBrowserTest;

public class FormLayoutInsideTableTest extends MultiBrowserTest {
    @Test
    public void nestedItemHasBorderTop() {
        openTestURL();

        List<WebElement> formLayoutRows = findElements(
                By.cssSelector("tr.v-formlayout-row"));
        WebElement secondNestedRow = formLayoutRows.get(1);

        WebElement td = secondNestedRow.findElement(By.tagName("td"));

        assertThat(td.getCssValue("border-top-width"), is("1px"));
    }
}