/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.grid;

import com.vaadin.shared.communication.ServerRpc;

/**
 * An RPC interface for the grid editor client-to-server communications.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public interface EditorServerRpc extends ServerRpc {

    /**
     * Asks the server to open the editor and bind data to it. When a bind
     * request is sent, it must be acknowledged with a
     * {@link EditorClientRpc#confirmBind() confirm call} before the client can
     * open the editor.
     *
     * @param rowIndex
     *            the index of the edited row
     */
    void bind(int rowIndex);

    /**
     * Asks the server to save unsaved changes in the editor to the data source.
     * When a save request is sent, it must be acknowledged with a
     * {@link EditorClientRpc#confirmSave() confirm call}.
     *
     * @param rowIndex
     *            the index of the edited row
     */
    void save(int rowIndex);

    /**
     * Tells the server to cancel editing. When sending a cancel request, the
     * client does not need to wait for confirmation by the server before hiding
     * the editor.
     *
     * @param rowIndex
     *            the index of the edited row
     */
    void cancel(int rowIndex);
}
