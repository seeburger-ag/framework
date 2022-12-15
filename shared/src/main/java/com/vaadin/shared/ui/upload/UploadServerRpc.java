/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.upload;

import com.vaadin.shared.communication.ServerRpc;

public interface UploadServerRpc extends ServerRpc {

    /**
     * Event sent when the file name of the upload component is changed.
     *
     * @param filename
     *            The filename
     */
    void change(String filename);

    /**
     * Called to poll the server to see if any changes have been made e.g. when
     * starting upload
     *
     * @since 7.6
     */
    void poll();

}
