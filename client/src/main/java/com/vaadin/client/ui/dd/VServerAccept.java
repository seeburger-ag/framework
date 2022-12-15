/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
/**
 *
 */
package com.vaadin.client.ui.dd;

import com.vaadin.client.UIDL;
import com.vaadin.event.dd.acceptcriteria.ServerSideCriterion;
import com.vaadin.shared.ui.dd.AcceptCriterion;

@AcceptCriterion(ServerSideCriterion.class)
final public class VServerAccept extends VAcceptCriterion {
    @Override
    public void accept(final VDragEvent drag, UIDL configuration,
            final VAcceptCallback callback) {

        VDragEventServerCallback acceptCallback = new VDragEventServerCallback() {
            @Override
            public void handleResponse(boolean accepted, UIDL response) {
                if (accepted) {
                    callback.accepted(drag);
                }
            }
        };
        VDragAndDropManager.get().visitServer(acceptCallback);
    }

    @Override
    public boolean needsServerSideCheck(VDragEvent drag, UIDL criterioUIDL) {
        return true;
    }

    @Override
    protected boolean accept(VDragEvent drag, UIDL configuration) {
        return false; // not used
    }
}
