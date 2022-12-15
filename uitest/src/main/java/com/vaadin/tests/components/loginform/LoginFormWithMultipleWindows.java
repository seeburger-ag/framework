/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.loginform;

import com.vaadin.server.LegacyApplication;
import com.vaadin.ui.LegacyWindow;
import com.vaadin.ui.LoginForm;
import com.vaadin.ui.LoginForm.LoginEvent;
import com.vaadin.ui.LoginForm.LoginListener;

@SuppressWarnings("serial")
public class LoginFormWithMultipleWindows extends LegacyApplication {

    @Override
    public void init() {
        setMainWindow(new LoginFormWindow());
    }

    public static class LoginFormWindow extends LegacyWindow {
        public LoginFormWindow() {
            super();

            LoginForm loginForm = new LoginForm();
            loginForm.setSizeUndefined();

            loginForm.addListener(new LoginListener() {

                private static final long serialVersionUID = 1L;

                @Override
                public void onLogin(LoginEvent event) {
                    showNotification(event.getLoginParameter("username") + ":"
                            + event.getLoginParameter("password"));

                }
            });

            addComponent(loginForm);
        }
    }

}
