/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.widgetset.server;

import com.vaadin.tests.widgetset.client.superText.SuperTextAreaState;
import com.vaadin.ui.TextArea;

/**
 * @author artamonov
 * @version $Id$
 */
public class SuperTextArea extends TextArea {

    @Override
    public SuperTextAreaState getState() {
        return (SuperTextAreaState) super.getState();
    }
}