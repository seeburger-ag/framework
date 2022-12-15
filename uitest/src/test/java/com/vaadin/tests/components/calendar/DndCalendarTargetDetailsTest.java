/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.calendar;

import org.openqa.selenium.WebElement;

import com.vaadin.testbench.By;
import com.vaadin.tests.components.table.DndTableTargetDetailsTest;

/**
 * Test for mouse details in CalendarTargetDetails class when DnD target is a
 * calendar.
 *
 * @author Vaadin Ltd
 */
public class DndCalendarTargetDetailsTest extends DndTableTargetDetailsTest {

    @Override
    protected WebElement getTarget() {
        return findElement(By.className("v-datecellslot-even"));
    }

}
