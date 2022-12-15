/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.widgetset.client.minitutorials.v7b1;

import com.vaadin.shared.annotations.Delayed;
import com.vaadin.shared.communication.ServerRpc;

public interface CapsLockWarningRpc extends ServerRpc {
    @Delayed(lastOnly = true)
    public void isCapsLockEnabled(boolean isCapsLockEnabled);
}
