/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.minitutorials.v7b9;

import com.vaadin.navigator.View;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;

public class SecretView extends MessageView implements View {
    public static final String NAME = "secret";

    public SecretView() {
        setCaption("Private messages");

        ((Layout) getContent()).addComponent(new Label("Some private stuff."));
    }

}
