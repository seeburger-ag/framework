/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.connectors;

import com.vaadin.client.renderers.Renderer;
import com.vaadin.client.widget.grid.RendererCellReference;
import com.vaadin.shared.ui.Connect;

/**
 * A connector for {@link UnsafeHtmlRenderer}
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
@Connect(com.vaadin.ui.renderers.HtmlRenderer.class)
public class UnsafeHtmlRendererConnector
        extends AbstractRendererConnector<String> {

    public static class UnsafeHtmlRenderer implements Renderer<String> {
        @Override
        public void render(RendererCellReference cell, String data) {
            cell.getElement().setInnerHTML(data);
        }
    }

    @Override
    public UnsafeHtmlRenderer getRenderer() {
        return (UnsafeHtmlRenderer) super.getRenderer();
    }
}
