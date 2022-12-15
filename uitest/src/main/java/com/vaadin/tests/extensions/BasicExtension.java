/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.extensions;

import com.vaadin.server.AbstractClientConnector;
import com.vaadin.server.AbstractExtension;

public class BasicExtension extends AbstractExtension {
    @Override
    public void extend(AbstractClientConnector target) {
        super.extend(target);
    }
}
