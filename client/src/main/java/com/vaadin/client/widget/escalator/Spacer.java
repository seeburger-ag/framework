/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.widget.escalator;

import com.google.gwt.dom.client.Element;

/**
 * A representation of a spacer element in a
 * {@link RowContainer.BodyRowContainer}.
 *
 * @since 7.5.0
 * @author Vaadin Ltd
 */
public interface Spacer {

    /**
     * Gets the root element for the spacer content.
     *
     * @return the root element for the spacer content
     */
    Element getElement();

    /**
     * Gets the decorative element for this spacer.
     */
    Element getDecoElement();

    /**
     * Gets the row index.
     *
     * @return the row index.
     */
    int getRow();
}
