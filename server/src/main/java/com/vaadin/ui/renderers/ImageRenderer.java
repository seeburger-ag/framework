/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.ui.renderers;

import com.vaadin.server.ExternalResource;
import com.vaadin.server.Resource;
import com.vaadin.server.ResourceReference;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.communication.URLReference;

import elemental.json.JsonValue;

/**
 * A renderer for presenting images.
 * <p>
 * The image for each rendered cell is read from a Resource-typed property in
 * the data source. Only {@link ExternalResource}s and {@link ThemeResource}s
 * are currently supported.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public class ImageRenderer extends ClickableRenderer<Resource> {

    /**
     * Creates a new image renderer.
     */
    public ImageRenderer() {
        super(Resource.class, null);
    }

    /**
     * Creates a new image renderer and adds the given click listener to it.
     *
     * @param listener
     *            the click listener to register
     */
    public ImageRenderer(RendererClickListener listener) {
        this();
        addClickListener(listener);
    }

    @Override
    public JsonValue encode(Resource resource) {
        if (!(resource == null || resource instanceof ExternalResource
                || resource instanceof ThemeResource)) {
            throw new IllegalArgumentException(
                    "ImageRenderer only supports ExternalResource and ThemeResource ("
                            + resource.getClass().getSimpleName() + " given)");
        }

        return encode(ResourceReference.create(resource, this, null),
                URLReference.class);
    }
}
