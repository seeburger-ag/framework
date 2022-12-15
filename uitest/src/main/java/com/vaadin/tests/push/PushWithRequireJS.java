/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.push;

import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.Push;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;

@Push
// https://cdnjs.cloudflare.com/ajax/libs/require.js/2.1.20/require.min.js
@JavaScript("require.min.js")
public class PushWithRequireJS extends AbstractTestUI {
    @Override
    protected void setup(VaadinRequest request) {
    }
}
