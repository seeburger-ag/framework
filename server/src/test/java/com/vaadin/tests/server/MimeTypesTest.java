/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.server;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.vaadin.server.ClassResource;
import com.vaadin.ui.Embedded;

public class MimeTypesTest {

    @Test
    public void testEmbeddedPDF() {
        Embedded e = new Embedded("A pdf", new ClassResource("file.pddf"));
        assertEquals("Invalid mimetype", "application/octet-stream",
                e.getMimeType());
        e = new Embedded("A pdf", new ClassResource("file.pdf"));
        assertEquals("Invalid mimetype", "application/pdf", e.getMimeType());
    }
}
