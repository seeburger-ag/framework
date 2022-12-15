/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.widgetset.server;

import com.vaadin.shared.ui.MediaControl;
import com.vaadin.ui.Label;

public class ClientRpcClassComponent extends Label {
    public void play() {
        getRpcProxy(MediaControl.class).play();
    }

    public void pause() {
        getRpcProxy(MediaControl.class).pause();
    }
}
