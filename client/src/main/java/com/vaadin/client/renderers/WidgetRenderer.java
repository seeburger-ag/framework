/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.renderers;

import com.google.gwt.dom.client.TableCellElement;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.WidgetUtil;
import com.vaadin.client.widget.grid.RendererCellReference;

/**
 * A renderer for rendering widgets into cells.
 *
 * @since 7.4
 * @author Vaadin Ltd
 * @param <T>
 *            the row data type
 * @param <W>
 *            the Widget type
 */
public abstract class WidgetRenderer<T, W extends Widget>
        extends ComplexRenderer<T> {

    @Override
    public void init(RendererCellReference cell) {
        // Implement if needed
    }

    /**
     * Creates a widget to attach to a cell. The widgets will be attached to the
     * cell after the cell element has been attached to DOM.
     *
     * @return widget to attach to a cell. All returned instances should be new
     *         widget instances without a parent.
     */
    public abstract W createWidget();

    @Override
    public void render(RendererCellReference cell, T data) {
        W w = getWidget(cell.getElement());
        assert w != null : "Widget not found in cell (" + cell.getColumn() + ","
                + cell.getRow() + ")";
        render(cell, data, w);
    }

    /**
     * Renders a cell with a widget. This provides a way to update any
     * information in the widget that is cell specific. Do not detach the Widget
     * here, it will be done automatically by the Grid when the widget is no
     * longer needed.
     * <p>
     * For optimal performance, work done in this method should be kept to a
     * minimum since it will be called continuously while the user is scrolling.
     * The renderer can use {@link Widget#setLayoutData(Object)} to store cell
     * data that might be needed in e.g. event listeners.
     *
     * @param cell
     *            The cell to render. Note that the cell is a flyweight and
     *            should not be stored and used outside of this method as its
     *            contents will change.
     * @param data
     *            the data of the cell
     * @param widget
     *            the widget embedded in the cell
     */
    public abstract void render(RendererCellReference cell, T data, W widget);

    /**
     * Returns the widget contained inside the given cell element. Cannot be
     * called for cells that do not contain a widget.
     *
     * @param e
     *            the element inside which to find a widget
     * @return the widget inside the element
     */
    protected W getWidget(TableCellElement e) {
        W w = getWidget(e, null);
        assert w != null : "Widget not found inside cell";
        return w;
    }

    /**
     * Returns the widget contained inside the given cell element, or null if it
     * is not an instance of the given class. Cannot be called for cells that do
     * not contain a widget.
     *
     * @param e
     *            the element inside to find a widget
     * @param klass
     *            the type of the widget to find
     * @return the widget inside the element, or null if its type does not match
     */
    protected static <W extends Widget> W getWidget(TableCellElement e,
            Class<W> klass) {
        W w = WidgetUtil.findWidget(e.getFirstChildElement(), klass);
        assert w == null || w.getElement() == e
                .getFirstChildElement() : "Widget not found inside cell";
        return w;
    }
}
