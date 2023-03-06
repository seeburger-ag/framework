/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.upload;

import com.vaadin.shared.communication.ClientRpc;

public interface UploadClientRpc extends ClientRpc {

    /**
     * Forces the upload the send selected file to the server.
     */
    void submitUpload();
}
