/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.textfield;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.testbench.elements.TextAreaElement;
import com.vaadin.testbench.elements.TextFieldElement;
import com.vaadin.tests.tb3.SingleBrowserTest;

import static org.junit.Assert.assertTrue;

public class TextChangeEventsTest extends SingleBrowserTest {

    @Test
    public void textAreaWaitsForTextChangeEvents() {
        openTestURL();

        TextAreaElement taDefault = $(TextAreaElement.class)
                .caption("Default text area").first();
        taDefault.sendKeys("abc");
        Assert.assertEquals(
                "1. Text change event for Default text area, text content currently:'abc' Cursor at index:3",
                getLogRow(0));

        TextAreaElement taTimeout = $(TextAreaElement.class)
                .caption("Timeout 3s").first();
        taTimeout.sendKeys("abc");
        Assert.assertEquals(
                "2. Text change event for Timeout 3s, text content currently:'abc' Cursor at index:3",
                getLogRow(0));

    }

    @Test
    public void textFieldWaitsForTextChangeEvents() {
        openTestURL();

        TextFieldElement tfDefault = $(TextFieldElement.class)
                .caption("Default").first();
        tfDefault.sendKeys("abc");
        Assert.assertEquals(
                "1. Text change event for Default, text content currently:'abc' Cursor at index:3",
                getLogRow(0));

        TextFieldElement tfEager = $(TextFieldElement.class).caption("Eager")
                .first();
        tfEager.sendKeys("abc");
        assertTrue(getLogRow(0).contains(
                "Text change event for Eager, text content currently:'abc' Cursor at index:3"));

        TextFieldElement tfTimeout = $(TextFieldElement.class)
                .caption("Timeout 3s").first();
        tfTimeout.sendKeys("abc");
        assertTrue(getLogRow(0).contains(
                "Text change event for Timeout 3s, text content currently:'abc' Cursor at index:3"));
                getLogRow(0);

    }
}
