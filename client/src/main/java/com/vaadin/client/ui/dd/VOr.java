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
import com.vaadin.event.dd.acceptcriteria.Or;
import com.vaadin.shared.ui.dd.AcceptCriterion;

/**
 *
 */
@AcceptCriterion(Or.class)
final public class VOr extends VAcceptCriterion implements VAcceptCallback {
    private boolean accepted;

    @Override
    public void accept(VDragEvent drag, UIDL configuration,
            VAcceptCallback callback) {
        int childCount = configuration.getChildCount();
        accepted = false;
        for (int i = 0; i < childCount; i++) {
            VAcceptCriterion crit = VAnd.getCriteria(drag, configuration, i);
            crit.accept(drag, configuration.getChildUIDL(i), this);
            if (accepted == true) {
                callback.accepted(drag);
                return;
            }
        }
    }

    @Override
    public boolean needsServerSideCheck(VDragEvent drag, UIDL criterioUIDL) {
        return false;
    }

    @Override
    protected boolean accept(VDragEvent drag, UIDL configuration) {
        return false; // not used here
    }

    @Override
    public void accepted(VDragEvent event) {
        accepted = true;
    }

}
