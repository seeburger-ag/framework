/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.embedded;

import java.applet.Applet;
import java.awt.Graphics;

public class TestApplet extends Applet {
    @Override
    public void paint(Graphics g) {
        g.drawString("Hello, I am an applet! Look at me!", 10, 20);
    }
}
