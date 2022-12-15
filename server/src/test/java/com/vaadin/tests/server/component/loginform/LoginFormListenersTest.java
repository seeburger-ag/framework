/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.server.component.loginform;

import com.vaadin.tests.server.component.AbstractListenerMethodsTestBase;
import com.vaadin.ui.LoginForm;
import com.vaadin.ui.LoginForm.LoginEvent;
import com.vaadin.ui.LoginForm.LoginListener;

public class LoginFormListenersTest extends AbstractListenerMethodsTestBase {
    public void testLoginListenerAddGetRemove() throws Exception {
        testListenerAddGetRemove(LoginForm.class, LoginEvent.class,
                LoginListener.class);
    }
}
