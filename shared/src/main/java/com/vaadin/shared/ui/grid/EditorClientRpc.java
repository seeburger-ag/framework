/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.grid;

import java.util.List;

import com.vaadin.shared.communication.ClientRpc;

/**
 * An RPC interface for the grid editor server-to-client communications.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
public interface EditorClientRpc extends ClientRpc {

    /**
     * Tells the client to open the editor and bind data to it.
     *
     * @param rowIndex
     *            the index of the edited row
     */
    void bind(int rowIndex);

    /**
     * Tells the client to cancel editing and hide the editor.
     *
     * @param rowIndex
     *            the index of the edited row
     */
    void cancel(int rowIndex);

    /**
     * Confirms a pending {@link EditorServerRpc#bind(int) bind request} sent by
     * the client.
     *
     * @param bindSucceeded
     *            <code>true</code> iff the bind action was successful
     */
    void confirmBind(boolean bindSucceeded);

    /**
     * Confirms a pending {@link EditorServerRpc#save(int) save request} sent by
     * the client.
     *
     * @param saveSucceeded
     *            <code>true</code> iff the save action was successful
     * @param errorMessage
     *            the error message to show the user
     * @param errorColumnsIds
     *            a list of column keys that should get error markers, or
     *            <code>null</code> if there should be no error markers
     */
    void confirmSave(boolean saveSucceeded, String errorMessage,
            List<String> errorColumnsIds);
}
