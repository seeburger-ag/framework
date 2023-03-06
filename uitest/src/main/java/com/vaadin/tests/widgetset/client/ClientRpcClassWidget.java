/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.widgetset.client;

import com.vaadin.client.ui.VLabel;
import com.vaadin.shared.ui.MediaControl;

public class ClientRpcClassWidget extends VLabel implements MediaControl {

    @Override
    public void play() {
        setText("play");
    }

    @Override
    public void pause() {
        setText("pause");
    }

}
