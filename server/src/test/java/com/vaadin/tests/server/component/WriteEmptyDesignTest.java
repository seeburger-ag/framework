/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.server.component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Assert;
import org.junit.Test;

import com.vaadin.ui.Component;
import com.vaadin.ui.declarative.Design;
import com.vaadin.ui.declarative.DesignContext;

/**
 * Test cases for checking that writing a component hierarchy with null root
 * produces an html document that has no elements in the html body.
 */
public class WriteEmptyDesignTest {

    @Test
    public void testWriteComponent() throws IOException {
        OutputStream os = new ByteArrayOutputStream();
        Design.write((Component) null, os);
        checkHtml(os.toString());
    }

    @Test
    public void testWriteContext() throws IOException {
        OutputStream os = new ByteArrayOutputStream();
        DesignContext ctx = new DesignContext();
        ctx.setRootComponent(null);
        Design.write(ctx, os);
        checkHtml(os.toString());
    }

    private void checkHtml(String html) {
        Document doc = Jsoup.parse(html);
        Element body = doc.body();
        Assert.assertEquals("There should be no elements in the html body.", "",
                body.html());
    }
}