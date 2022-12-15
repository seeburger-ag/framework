/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.client.widget.escalator;

import com.google.gwt.dom.client.TableRowElement;
import com.vaadin.client.widgets.Escalator;

/**
 * A representation of a row in an {@link Escalator}.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public interface Row {
    /**
     * Gets the row index.
     *
     * @return the row index
     */
    public int getRow();

    /**
     * Gets the root element for this row.
     * <p>
     * The {@link EscalatorUpdater} may update the class names of the element
     * and add inline styles, but may not modify the contained DOM structure.
     * <p>
     * If you wish to modify the cells within this row element, access them via
     * the <code>List&lt;{@link Cell}&gt;</code> objects passed in to
     * {@code EscalatorUpdater.updateCells(Row, List)}
     *
     * @return the root element of the row
     */
    public TableRowElement getElement();
}