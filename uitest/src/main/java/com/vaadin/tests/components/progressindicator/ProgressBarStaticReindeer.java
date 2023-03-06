/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.progressindicator;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.ProgressBar;
import com.vaadin.ui.themes.Reindeer;

@Theme(Reindeer.THEME_NAME)
public class ProgressBarStaticReindeer extends AbstractTestUI {
    @Override
    protected void setup(VaadinRequest request) {
        ProgressBar progressBar = new ProgressBar();
        progressBar.addStyleName(Reindeer.PROGRESSBAR_STATIC);
        addComponent(progressBar);
    }
}
