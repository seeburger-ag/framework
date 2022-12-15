/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.minitutorials.v7b1;

import com.vaadin.server.AbstractExtension;
import com.vaadin.tests.widgetset.client.minitutorials.v7b1.CapsLockWarningRpc;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;

public class CapsLockWarningWithRpc extends AbstractExtension {
    public CapsLockWarningWithRpc() {
        registerRpc(new CapsLockWarningRpc() {
            @Override
            public void isCapsLockEnabled(boolean isCapsLockEnabled) {
                Notification.show("Caps Lock was "
                        + (isCapsLockEnabled ? "enabled" : "disabled"));
            }
        });
    }

    public void extend(PasswordField field) {
        super.extend(field);
    }
}
