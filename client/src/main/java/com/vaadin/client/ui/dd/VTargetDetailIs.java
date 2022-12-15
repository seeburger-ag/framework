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
import com.vaadin.event.dd.acceptcriteria.TargetDetailIs;
import com.vaadin.shared.ui.dd.AcceptCriterion;

@AcceptCriterion(TargetDetailIs.class)
final public class VTargetDetailIs extends VAcceptCriterion {

    @Override
    protected boolean accept(VDragEvent drag, UIDL configuration) {
        String name = configuration.getStringAttribute("p");
        String t = configuration.hasAttribute("t")
                ? configuration.getStringAttribute("t").intern() : "s";
        Object value = null;
        if (t == "s") {
            value = configuration.getStringAttribute("v");
        } else if (t == "b") {
            value = configuration.getBooleanAttribute("v");
        }
        if (value != null) {
            Object object = drag.getDropDetails().get(name);
            if (object instanceof Enum) {
                return ((Enum<?>) object).name().equals(value);
            } else {
                return value.equals(object);
            }
        } else {
            return false;
        }

    }
}
