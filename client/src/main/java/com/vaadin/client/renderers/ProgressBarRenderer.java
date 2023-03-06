/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.renderers;

import com.google.gwt.core.shared.GWT;
import com.vaadin.client.ui.VProgressBar;
import com.vaadin.client.widget.grid.RendererCellReference;

/**
 * A Renderer that represents a double value as a graphical progress bar.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public class ProgressBarRenderer extends WidgetRenderer<Double, VProgressBar> {

    @Override
    public VProgressBar createWidget() {
        VProgressBar progressBar = GWT.create(VProgressBar.class);
        progressBar.addStyleDependentName("static");
        return progressBar;
    }

    @Override
    public void render(RendererCellReference cell, Double data,
            VProgressBar progressBar) {
        if (data == null) {
            progressBar.setEnabled(false);
        } else {
            progressBar.setEnabled(true);
            progressBar.setState(data.floatValue());
        }
    }
}
