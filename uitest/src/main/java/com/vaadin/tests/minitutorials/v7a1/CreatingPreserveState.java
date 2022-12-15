/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.minitutorials.v7a1;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

/**
 * Mini tutorial code for
 * https://vaadin.com/wiki/-/wiki/Main/Creating%20an%20application
 * %20that%20preserves%20state%20on%20refresh
 *
 * @author Vaadin Ltd
 * @since 7.0.0
 */
@PreserveOnRefresh
public class CreatingPreserveState extends UI {
    private static int instanceCounter = 0;

    private final CssLayout content = new CssLayout();

    @Override
    public void init(VaadinRequest request) {
        TextField tf = new TextField("Instance #" + (++instanceCounter));
        tf.setImmediate(true);

        content.addComponent(tf);
        setContent(content);
    }

    @Override
    protected void refresh(VaadinRequest request) {
        content.addComponent(
                new Label("UI was refreshed @" + System.currentTimeMillis()));
    }
}
