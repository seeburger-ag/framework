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
package com.vaadin.event.dd.acceptcriteria;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.vaadin.event.TransferableImpl;
import com.vaadin.event.dd.DragAndDropEvent;
import com.vaadin.server.PaintException;
import com.vaadin.server.PaintTarget;
import com.vaadin.ui.Component;

/**
 * Client side criteria that checks if the drag source is one of the given
 * components.
 *
 * @since 6.3
 */
@SuppressWarnings("serial")
public class SourceIs extends ClientSideCriterion {

    private Component[] components;

    public SourceIs(Component... component) {
        components = component;
    }

    @Override
    public void paintContent(PaintTarget target) throws PaintException {
        super.paintContent(target);
        int paintedComponents = 0;
        for (int i = 0; i < components.length; i++) {
            Component c = components[i];
            if (c.isAttached()) {
                target.addAttribute("component" + paintedComponents++, c);
            } else {
                Logger.getLogger(SourceIs.class.getName()).log(Level.WARNING,
                        "SourceIs component {0} at index {1} is not attached to the component hierachy and will thus be ignored",
                        new Object[] { c.getClass().getName(),
                                Integer.valueOf(i) });
            }
        }
        target.addAttribute("c", paintedComponents);
    }

    @Override
    public boolean accept(DragAndDropEvent dragEvent) {
        if (dragEvent.getTransferable() instanceof TransferableImpl) {
            Component sourceComponent = ((TransferableImpl) dragEvent
                    .getTransferable()).getSourceComponent();
            for (Component c : components) {
                if (c == sourceComponent) {
                    return true;
                }
            }
        }

        return false;
    }

}
