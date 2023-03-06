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
 * A compound criterion that accepts the drag if all of its criteria accepts the
 * drag.
 *
 * @see Or
 *
 * @since 6.3
 *
 */
public class And extends ClientSideCriterion {

    private static final long serialVersionUID = -5242574480825471748L;
    protected ClientSideCriterion[] criteria;

    /**
     *
     * @param criteria
     *            criteria of which the And criterion will be composed
     */
    public And(ClientSideCriterion... criteria) {
        this.criteria = criteria;
    }

    @Override
    public void paintContent(PaintTarget target) throws PaintException {
        super.paintContent(target);
        for (ClientSideCriterion crit : criteria) {
            crit.paint(target);
        }
    }

    @Override
    public boolean accept(DragAndDropEvent dragEvent) {
        for (ClientSideCriterion crit : criteria) {
            if (!crit.accept(dragEvent)) {
                return false;
            }
        }
        return true;
    }

}
