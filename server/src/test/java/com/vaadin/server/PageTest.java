/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.server;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;

import com.vaadin.server.Page.BrowserWindowResizeEvent;
import com.vaadin.server.Page.BrowserWindowResizeListener;
import com.vaadin.shared.ui.ui.PageState;
import com.vaadin.ui.UI;

/**
 *
 * Tests for {@link Page}
 *
 * @author Vaadin Ltd
 */
public class PageTest {

    @Test
    public void removeBrowserWindowResizeListener_listenerIsAttached_listenerRemoved() {
        Page page = new Page(EasyMock.createMock(UI.class),
                EasyMock.createMock(PageState.class));

        TestBrowserWindowResizeListener listener = new TestBrowserWindowResizeListener();
        page.addBrowserWindowResizeListener(listener);
        page.removeBrowserWindowResizeListener(listener);

        page.updateBrowserWindowSize(0, 0, true);

        Assert.assertFalse("Listener is called after removal",
                listener.isCalled());
    }

    @Test
    public void removeBrowserWindowResizeListener_listenerIsNotAttached_stateIsUpdated() {
        TestPage page = new TestPage(EasyMock.createMock(UI.class),
                EasyMock.createMock(PageState.class));

        BrowserWindowResizeListener listener = EasyMock
                .createMock(BrowserWindowResizeListener.class);
        page.removeBrowserWindowResizeListener(listener);

        Assert.assertFalse(
                "Page state 'hasResizeListeners' property has wrong value",
                page.getState(false).hasResizeListeners);
    }

    private static class TestPage extends Page {

        public TestPage(UI uI, PageState state) {
            super(uI, state);
        }

        @Override
        protected PageState getState(boolean markAsDirty) {
            return super.getState(markAsDirty);
        }

    }

    private static class TestBrowserWindowResizeListener
            implements BrowserWindowResizeListener {

        @Override
        public void browserWindowResized(BrowserWindowResizeEvent event) {
            isCalled = true;
        }

        public boolean isCalled() {
            return isCalled;
        }

        private boolean isCalled;

    }
}
