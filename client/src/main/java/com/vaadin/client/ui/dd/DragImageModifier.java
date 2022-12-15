/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.dd;

import com.google.gwt.dom.client.Element;

/**
 * Interface implemented by widgets if the drag image used for drag'n'drop
 * requires additional initialization/configuration. The method
 * {@link #modifyDragImage(Element)} is called for each element in the
 * automatically generated drag image.
 *
 * @since 7.2
 * @author Vaadin Ltd
 */
public interface DragImageModifier {

    /**
     * This method is called for cloned <code>element</code> which corresponds
     * to the widget element. One could modify/correct this <code>element</code>
     * for drag image.
     *
     * @param element
     *            cloned element of drag image
     */
    void modifyDragImage(Element element);
}
