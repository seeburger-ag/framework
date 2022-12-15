/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.renderers;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Image;
import com.vaadin.client.widget.grid.RendererCellReference;

/**
 * A renderer that renders an image into a cell. Click handlers can be added to
 * the renderer, invoked every time any of the images rendered by that rendered
 * is clicked.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public class ImageRenderer extends ClickableRenderer<String, Image> {

    public static final String TRANSPARENT_GIF_1PX = "data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7";

    @Override
    public Image createWidget() {
        Image image = GWT.create(Image.class);
        image.addClickHandler(this);
        return image;
    }

    @Override
    public void render(RendererCellReference cell, String url, Image image) {
        if (url == null) {
            image.setUrl(TRANSPARENT_GIF_1PX);
        } else {
            image.setUrl(url);
        }
    }
}
