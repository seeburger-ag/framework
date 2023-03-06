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
import com.vaadin.shared.ui.dd.AcceptCriterion;
import com.vaadin.ui.AbstractSelect;

@AcceptCriterion(AbstractSelect.AcceptItem.class)
final public class VItemIdIs extends VAcceptCriterion {

    @Override
    protected boolean accept(VDragEvent drag, UIDL configuration) {
        try {
            String pid = configuration.getStringAttribute("s");
            ComponentConnector dragSource = drag.getTransferable()
                    .getDragSource();
            String pid2 = dragSource.getConnectorId();
            if (pid2.equals(pid)) {
                Object searchedId = drag.getTransferable().getData("itemId");
                String[] stringArrayAttribute = configuration
                        .getStringArrayAttribute("keys");
                for (String string : stringArrayAttribute) {
                    if (string.equals(searchedId)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
        }
        return false;
    }
}
