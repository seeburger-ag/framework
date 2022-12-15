/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.renderers;

import com.vaadin.client.widget.grid.RendererCellReference;

/**
 * Renderer that renders text into a cell.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public class TextRenderer implements Renderer<String> {

    @Override
    public void render(RendererCellReference cell, String text) {
        cell.getElement().setInnerText(text);
    }
}
