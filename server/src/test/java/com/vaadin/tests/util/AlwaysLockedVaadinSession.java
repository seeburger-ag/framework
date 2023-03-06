/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.util;

import com.vaadin.server.MockVaadinSession;
import com.vaadin.server.VaadinService;

public class AlwaysLockedVaadinSession extends MockVaadinSession {

    public AlwaysLockedVaadinSession(VaadinService service) {
        super(service);
        lock();
    }

}
