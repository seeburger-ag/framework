/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.design;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.declarative.Design;
import com.vaadin.ui.declarative.DesignException;

public class InvalidTagNamesTest {

    @Test(expected = DesignException.class)
    public void tagWithoutDash() {
        readDesign("<vbutton>foo</vbutton>");
    }

    @Test
    public void emptyTag() {
        // JSoup parses empty tags into text nodes
        Component c = readDesign("<>foo</>");
        Assert.assertNull(c);
    }

    @Test(expected = DesignException.class)
    public void onlyPrefix() {
        readDesign("<vaadin->foo</vaadin->");
    }

    @Test
    public void onlyClass() {
        // JSoup will refuse to parse tags starting with - and convert them into
        // text nodes instead
        Component c = readDesign("<-v>foo</-v>");
        Assert.assertNull(c);
    }

    @Test(expected = DesignException.class)
    public void unknownClass() {
        readDesign("<vaadin-unknownbutton>foo</vaadin-unknownbutton>");
    }

    @Test(expected = DesignException.class)
    public void unknownTag() {
        readDesign("<x-button></x-button>");
    }

    // @Test(expected = DesignException.class)
    // This is a side effect of not actively checking for invalid input. Will be
    // parsed currently as <vaadin-button> (this should not be considered API)
    public void tagEndsInDash() {
        Component c = readDesign("<vaadin-button-></vaadin-button->");
        Assert.assertTrue(c.getClass() == Button.class);
    }

    // @Test(expected = DesignException.class)
    // This is a side effect of not actively checking for invalid input. Will be
    // parsed currently as <vaadin-button> (this should not be considered API)
    public void tagEndsInTwoDashes() {
        Component c = readDesign("<vaadin-button--></vaadin-button-->");
        Assert.assertTrue(c.getClass() == Button.class);
    }

    // @Test(expected = DesignException.class)
    // This is a side effect of not actively checking for invalid input. Will be
    // parsed currently as <vaadin-button> (this should not be considered API)
    public void tagWithTwoDashes() {
        Component c = readDesign("<vaadin--button></vaadin--button>");
        Assert.assertTrue(c.getClass() == Button.class);
    }

    @Test(expected = DesignException.class)
    public void specialCharacters() {
        readDesign("<vaadin-button-&!#></vaadin-button-&!#>");
    }

    private Component readDesign(String string) {
        try {
            return Design
                    .read(new ByteArrayInputStream(string.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
