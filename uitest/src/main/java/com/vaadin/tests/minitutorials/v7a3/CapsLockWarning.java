/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.minitutorials.v7a3;

import com.vaadin.server.AbstractExtension;
import com.vaadin.ui.PasswordField;

public class CapsLockWarning extends AbstractExtension {
    protected CapsLockWarning(PasswordField field) {
        // Non-public constructor to discourage direct instantiation
        extend(field);
    }

    public static CapsLockWarning warnFor(PasswordField field) {
        return new CapsLockWarning(field);
    }
}
