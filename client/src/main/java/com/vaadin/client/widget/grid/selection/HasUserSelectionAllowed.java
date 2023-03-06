/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.widget.grid.selection;

/**
 * Interface implemented by selection models which support disabling client side
 * selection while still allowing programmatic selection on the server.
 *
 * @param <T>
 *            Grid's row type
 *
 * @since 7.7.7
 */
public interface HasUserSelectionAllowed<T> extends SelectionModel<T> {

    /**
     * Checks if the user is allowed to change the selection.
     *
     * @return <code>true</code> if the user is allowed to change the selection,
     *         <code>false</code> otherwise
     */
    public boolean isUserSelectionAllowed();

    /**
     * Sets whether the user is allowed to change the selection.
     *
     * @param userSelectionAllowed
     *            <code>true</code> if the user is allowed to change the
     *            selection, <code>false</code> otherwise
     */
    public void setUserSelectionAllowed(boolean userSelectionAllowed);

}
