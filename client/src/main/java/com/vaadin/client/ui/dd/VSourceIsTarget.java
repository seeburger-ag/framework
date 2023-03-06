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

import com.vaadin.client.ComponentConnector;
import com.vaadin.client.UIDL;
import com.vaadin.event.dd.acceptcriteria.SourceIsTarget;
import com.vaadin.shared.ui.dd.AcceptCriterion;

@AcceptCriterion(SourceIsTarget.class)
final public class VSourceIsTarget extends VAcceptCriterion {

    @Override
    protected boolean accept(VDragEvent drag, UIDL configuration) {
        ComponentConnector dragSource = drag.getTransferable().getDragSource();
        ComponentConnector paintable = VDragAndDropManager.get()
                .getCurrentDropHandler().getConnector();

        return paintable == dragSource;
    }
}
