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

import java.io.Serializable;

import com.vaadin.event.Transferable;
import com.vaadin.event.dd.DragAndDropEvent;
import com.vaadin.event.dd.DropHandler;
import com.vaadin.server.PaintException;
import com.vaadin.server.PaintTarget;

/**
 * Criterion that can be used create policy to accept/discard dragged content
 * (presented by {@link Transferable}).
 *
 * The drag and drop mechanism will verify the criteria returned by
 * {@link DropHandler#getAcceptCriterion()} before calling
 * {@link DropHandler#drop(DragAndDropEvent)}.
 *
 * The criteria can be evaluated either on the client (browser - see
 * {@link ClientSideCriterion}) or on the server (see
 * {@link ServerSideCriterion}). If no constraints are needed, an
 * {@link AcceptAll} can be used.
 *
 * In addition to accepting or rejecting a possible drop, criteria can provide
 * additional hints for client side painting.
 *
 * @see DropHandler
 * @see ClientSideCriterion
 * @see ServerSideCriterion
 *
 * @since 6.3
 */
public interface AcceptCriterion extends Serializable {

    /**
     * Returns whether the criteria can be checked on the client or whether a
     * server request is needed to check the criteria.
     *
     * This requirement may depend on the state of the criterion (e.g. logical
     * operations between criteria), so this cannot be based on a marker
     * interface.
     */
    public boolean isClientSideVerifiable();

    public void paint(PaintTarget target) throws PaintException;

    /**
     * This needs to be implemented iff criterion does some lazy server side
     * initialization. The UIDL painted in this method will be passed to client
     * side drop handler implementation. Implementation can assume that
     * {@link #accept(DragAndDropEvent)} is called before this method.
     *
     * @param target
     * @throws PaintException
     */
    public void paintResponse(PaintTarget target) throws PaintException;

    /**
     * Validates the data in event to be appropriate for the
     * {@link DropHandler#drop(DragAndDropEvent)} method.
     * <p>
     * Note that even if your criterion is validated on client side, you should
     * always validate the data on server side too.
     *
     * @param dragEvent
     * @return
     */
    public boolean accept(DragAndDropEvent dragEvent);
}
