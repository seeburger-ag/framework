/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.event.dd.acceptcriteria;

import java.io.Serializable;

import com.vaadin.event.Transferable;
import com.vaadin.server.PaintException;
import com.vaadin.server.PaintTarget;

/**
 * Parent class for criteria which are verified on the server side during a drag
 * operation to accept/discard dragged content (presented by
 * {@link Transferable}).
 * <p>
 * Subclasses should implement the
 * {@link AcceptCriterion#accept(com.vaadin.event.dd.DragAndDropEvent)} method.
 * <p>
 * As all server side state can be used to make a decision, this is more
 * flexible than {@link ClientSideCriterion}. However, this does require
 * additional requests from the browser to the server during a drag operation.
 *
 * @see AcceptCriterion
 * @see ClientSideCriterion
 *
 * @since 6.3
 */
public abstract class ServerSideCriterion
        implements Serializable, AcceptCriterion {

    private static final long serialVersionUID = 2128510128911628902L;

    @Override
    public final boolean isClientSideVerifiable() {
        return false;
    }

    @Override
    public void paint(PaintTarget target) throws PaintException {
        target.startTag("-ac");
        target.addAttribute("name", getIdentifier());
        paintContent(target);
        target.endTag("-ac");
    }

    public void paintContent(PaintTarget target) {
    }

    @Override
    public void paintResponse(PaintTarget target) throws PaintException {
    }

    protected String getIdentifier() {
        return ServerSideCriterion.class.getCanonicalName();
    }
}
