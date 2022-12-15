/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.widgetset.client.grid;

import com.vaadin.client.connectors.AbstractRendererConnector;
import com.vaadin.client.renderers.Renderer;
import com.vaadin.client.widget.grid.RendererCellReference;
import com.vaadin.shared.ui.Connect;

@Connect(com.vaadin.tests.components.grid.IntArrayRenderer.class)
public class IntArrayRendererConnector
        extends AbstractRendererConnector<int[]> {

    public static class IntArrayRenderer implements Renderer<int[]> {
        private static final String JOINER = " :: ";

        @Override
        public void render(RendererCellReference cell, int[] data) {
            String text = "";
            for (int i : data) {
                text += i + JOINER;
            }
            if (!text.isEmpty()) {
                text = text.substring(0, text.length() - JOINER.length());
            }
            cell.getElement().setInnerText(text);
        }
    }

    @Override
    public IntArrayRenderer getRenderer() {
        return (IntArrayRenderer) super.getRenderer();
    }
}
