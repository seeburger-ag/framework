/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.dd;

import com.vaadin.client.UIDL;

public abstract class VAcceptCriterion {

    /**
     * Checks if current drag event has valid drop target and target accepts the
     * transferable. If drop target is valid, callback is used.
     *
     * @param drag
     * @param configuration
     * @param callback
     */
    public void accept(final VDragEvent drag, UIDL configuration,
            final VAcceptCallback callback) {
        if (needsServerSideCheck(drag, configuration)) {
            VDragEventServerCallback acceptCallback = new VDragEventServerCallback() {
                @Override
                public void handleResponse(boolean accepted, UIDL response) {
                    if (accepted) {
                        callback.accepted(drag);
                    }
                }
            };
            VDragAndDropManager.get().visitServer(acceptCallback);
        } else {
            boolean validates = accept(drag, configuration);
            if (validates) {
                callback.accepted(drag);
            }
        }

    }

    protected abstract boolean accept(VDragEvent drag, UIDL configuration);

    public boolean needsServerSideCheck(VDragEvent drag, UIDL criterioUIDL) {
        return false;
    }

}
