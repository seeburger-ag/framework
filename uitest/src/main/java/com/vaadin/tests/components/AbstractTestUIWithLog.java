/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.util.Log;
import com.vaadin.ui.VerticalLayout;

public abstract class AbstractTestUIWithLog extends AbstractTestUI {

    protected Log log = new Log(getLogSize());

    @Override
    public void init(VaadinRequest request) {
        super.init(request);
        ((VerticalLayout) getContent()).addComponent(log, 0);
    }

    protected void log(String message) {
        log.log(message);
    }

    protected int getLogSize() {
        return 5;
    }

}
