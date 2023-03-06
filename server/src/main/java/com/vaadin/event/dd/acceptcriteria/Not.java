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

import com.vaadin.event.dd.DragAndDropEvent;
import com.vaadin.server.PaintException;
import com.vaadin.server.PaintTarget;

/**
 * Criterion that wraps another criterion and inverts its return value.
 *
 * @since 6.3
 *
 */
public class Not extends ClientSideCriterion {

    private static final long serialVersionUID = 1131422338558613244L;
    private AcceptCriterion acceptCriterion;

    public Not(ClientSideCriterion acceptCriterion) {
        this.acceptCriterion = acceptCriterion;
    }

    @Override
    public void paintContent(PaintTarget target) throws PaintException {
        super.paintContent(target);
        acceptCriterion.paint(target);
    }

    @Override
    public boolean accept(DragAndDropEvent dragEvent) {
        return !acceptCriterion.accept(dragEvent);
    }

}
