/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.minitutorials.v7a3;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.UI;

public class AnalyticsUI extends UI {

    @Override
    protected void init(VaadinRequest request) {
        final Analytics analytics = new Analytics(this, "UA-33036133-12");

        setContent(new Button("Track pageview", new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                analytics.trackPageview("/fake/url");
            }
        }));
    }

}
