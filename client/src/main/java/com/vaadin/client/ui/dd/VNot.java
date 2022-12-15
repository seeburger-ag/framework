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
import com.vaadin.client.VConsole;
import com.vaadin.event.dd.acceptcriteria.Not;
import com.vaadin.shared.ui.dd.AcceptCriterion;

/**
 * TODO implementation could now be simplified/optimized
 *
 */
@AcceptCriterion(Not.class)
final public class VNot extends VAcceptCriterion {
    private boolean b1;
    private VAcceptCriterion crit1;

    @Override
    public void accept(VDragEvent drag, UIDL configuration,
            VAcceptCallback callback) {
        if (crit1 == null) {
            crit1 = getCriteria(drag, configuration, 0);
            if (crit1 == null) {
                VConsole.log("Not criteria didn't found a child criteria");
                return;
            }
        }

        b1 = false;

        VAcceptCallback accept1cb = new VAcceptCallback() {
            @Override
            public void accepted(VDragEvent event) {
                b1 = true;
            }
        };

        crit1.accept(drag, configuration.getChildUIDL(0), accept1cb);
        if (!b1) {
            callback.accepted(drag);
        }
    }

    private VAcceptCriterion getCriteria(VDragEvent drag, UIDL configuration,
            int i) {
        UIDL childUIDL = configuration.getChildUIDL(i);
        return VAcceptCriteria.get(childUIDL.getStringAttribute("name"));
    }

    @Override
    public boolean needsServerSideCheck(VDragEvent drag, UIDL criterioUIDL) {
        return false; // TODO enforce on server side
    }

    @Override
    protected boolean accept(VDragEvent drag, UIDL configuration) {
        return false; // not used
    }
}
