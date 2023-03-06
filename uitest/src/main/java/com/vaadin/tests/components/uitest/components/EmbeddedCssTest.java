/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.uitest.components;

import com.vaadin.server.ThemeResource;
import com.vaadin.tests.components.uitest.TestSampler;
import com.vaadin.ui.BrowserFrame;
import com.vaadin.ui.Embedded;

public class EmbeddedCssTest {

    private int debugIdCounter = 0;

    public EmbeddedCssTest(TestSampler parent) {
        Embedded e = new Embedded("Embedded with a caption",
                new ThemeResource(parent.ICON_URL));
        e.setId("embedded" + debugIdCounter);
        parent.addComponent(e);

        e = new Embedded(null, new ThemeResource(parent.ICON_URL));
        e.setId("embedded" + debugIdCounter);
        parent.addComponent(e);

        BrowserFrame eBrowser = new BrowserFrame();
        eBrowser.setCaption("A embedded browser");
        eBrowser.setSource(null);
        eBrowser.setHeight("150px");
        eBrowser.setWidth("300px");
        eBrowser.setId("embedded" + debugIdCounter);
        parent.addComponent(eBrowser);
    }

}
