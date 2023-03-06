/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.util;

import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.UI;

public class MockUI extends UI {

    public MockUI() {
        this(findOrcreateSession());
    }

    public MockUI(VaadinSession session) {
        setSession(session);
        setCurrent(this);
    }

    @Override
    protected void init(VaadinRequest request) {
        // Do nothing
    }

    private static VaadinSession findOrcreateSession() {
        VaadinSession session = VaadinSession.getCurrent();
        if (session == null) {
            session = new AlwaysLockedVaadinSession(null);
            VaadinSession.setCurrent(session);
        }
        return session;
    }
}
