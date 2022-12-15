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
import com.vaadin.event.dd.acceptcriteria.AcceptAll;
import com.vaadin.shared.ui.dd.AcceptCriterion;

@AcceptCriterion(AcceptAll.class)
final public class VAcceptAll extends VAcceptCriterion {

    @Override
    protected boolean accept(VDragEvent drag, UIDL configuration) {
        return true;
    }
}
