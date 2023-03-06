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
import com.vaadin.event.dd.acceptcriteria.And;
import com.vaadin.shared.ui.dd.AcceptCriterion;

@AcceptCriterion(And.class)
final public class VAnd extends VAcceptCriterion implements VAcceptCallback {
    private boolean b1;

    static VAcceptCriterion getCriteria(VDragEvent drag, UIDL configuration,
            int i) {
        UIDL childUIDL = configuration.getChildUIDL(i);
        return VAcceptCriteria.get(childUIDL.getStringAttribute("name"));
    }

    @Override
    protected boolean accept(VDragEvent drag, UIDL configuration) {
        int childCount = configuration.getChildCount();
        for (int i = 0; i < childCount; i++) {
            VAcceptCriterion crit = getCriteria(drag, configuration, i);
            b1 = false;
            crit.accept(drag, configuration.getChildUIDL(i), this);
            if (!b1) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void accepted(VDragEvent event) {
        b1 = true;
    }

}
