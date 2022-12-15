/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.server.component.browserframe;

import org.junit.Test;

import com.vaadin.server.ExternalResource;
import com.vaadin.tests.design.DeclarativeTestBase;
import com.vaadin.ui.BrowserFrame;

/**
 * Tests declarative support for implementations of {@link BrowserFrame}.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public class BrowserFrameDeclarativeTest
        extends DeclarativeTestBase<BrowserFrame> {

    protected String getDesign() {
        return "<vaadin-browser-frame source='http://foo.bar/some.html' />";
    }

    protected BrowserFrame getExpectedResult() {
        BrowserFrame i = new BrowserFrame();
        i.setSource(new ExternalResource("http://foo.bar/some.html"));
        return i;
    };

    @Test
    public void read() {
        testRead(getDesign(), getExpectedResult());
    }

    @Test
    public void write() {
        testWrite(getDesign(), getExpectedResult());
    }

    @Test
    public void testEmpty() {
        testRead("<vaadin-browser-frame/>", new BrowserFrame());
    }
}
