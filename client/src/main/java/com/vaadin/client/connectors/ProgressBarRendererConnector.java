/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.connectors;

import com.vaadin.client.renderers.ProgressBarRenderer;
import com.vaadin.shared.ui.Connect;

/**
 * A connector for {@link ProgressBarRenderer}.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
@Connect(com.vaadin.ui.renderers.ProgressBarRenderer.class)
public class ProgressBarRendererConnector
        extends AbstractRendererConnector<Double> {

    @Override
    public ProgressBarRenderer getRenderer() {
        return (ProgressBarRenderer) super.getRenderer();
    }
}
