/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.dd;

import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ConnectorMap;
import com.vaadin.client.UIDL;
import com.vaadin.event.dd.acceptcriteria.SourceIs;
import com.vaadin.shared.ui.dd.AcceptCriterion;

/**
 * TODO Javadoc!
 *
 * @since 6.3
 */
@AcceptCriterion(SourceIs.class)
final public class VDragSourceIs extends VAcceptCriterion {

    @Override
    protected boolean accept(VDragEvent drag, UIDL configuration) {
        try {
            ComponentConnector component = drag.getTransferable()
                    .getDragSource();
            int c = configuration.getIntAttribute("c");
            for (int i = 0; i < c; i++) {
                String requiredPid = configuration
                        .getStringAttribute("component" + i);
                VDropHandler currentDropHandler = VDragAndDropManager.get()
                        .getCurrentDropHandler();
                ComponentConnector paintable = (ComponentConnector) ConnectorMap
                        .get(currentDropHandler.getApplicationConnection())
                        .getConnector(requiredPid);
                if (paintable == component) {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }
}
