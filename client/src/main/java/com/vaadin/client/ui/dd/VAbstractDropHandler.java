/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.dd;

import java.util.Iterator;

import com.google.gwt.user.client.Command;
import com.vaadin.client.ComponentConnector;
import com.vaadin.client.UIDL;
import com.vaadin.event.Transferable;
import com.vaadin.event.dd.DropTarget;
import com.vaadin.event.dd.acceptcriteria.AcceptCriterion;

public abstract class VAbstractDropHandler implements VDropHandler {

    private UIDL criterioUIDL;
    private VAcceptCriterion acceptCriteria = new VAcceptAll();

    /**
     * Implementor/user of {@link VAbstractDropHandler} must pass the UIDL
     * painted by {@link AcceptCriterion} to this method. Practically the
     * details about {@link AcceptCriterion} are saved.
     *
     * @param uidl
     */
    public void updateAcceptRules(UIDL uidl) {
        criterioUIDL = uidl;
        /*
         * supports updating the accept rule root directly or so that it is
         * contained in given uidl node
         */
        if (!uidl.getTag().equals("-ac")) {
            Iterator<Object> childIterator = uidl.getChildIterator();
            while (!uidl.getTag().equals("-ac") && childIterator.hasNext()) {
                uidl = (UIDL) childIterator.next();
            }
        }
        acceptCriteria = VAcceptCriteria.get(uidl.getStringAttribute("name"));
        if (acceptCriteria == null) {
            throw new IllegalArgumentException(
                    "No accept criteria found with given name "
                            + uidl.getStringAttribute("name"));
        }
    }

    /**
     * Default implementation does nothing.
     */
    @Override
    public void dragOver(VDragEvent drag) {

    }

    /**
     * Default implementation does nothing. Implementors should clean possible
     * emphasis or drag icons here.
     */
    @Override
    public void dragLeave(VDragEvent drag) {

    }

    /**
     * The default implementation in {@link VAbstractDropHandler} checks if the
     * Transferable is accepted.
     * <p>
     * If transferable is accepted (either via server visit or client side
     * rules) the default implementation calls abstract
     * {@link #dragAccepted(VDragEvent)} method.
     * <p>
     * If drop handler has distinct places where some parts may accept the
     * {@link Transferable} and others don't, one should use similar validation
     * logic in dragOver method and replace this method with empty
     * implementation.
     *
     */
    @Override
    public void dragEnter(final VDragEvent drag) {
        validate(new VAcceptCallback() {
            @Override
            public void accepted(VDragEvent event) {
                dragAccepted(drag);
            }
        }, drag);
    }

    /**
     * This method is called when a valid drop location was found with
     * {@link AcceptCriterion} either via client or server side check.
     * <p>
     * Implementations can set some hints for users here to highlight that the
     * drag is on a valid drop location.
     *
     * @param drag
     */
    abstract protected void dragAccepted(VDragEvent drag);

    protected void validate(final VAcceptCallback cb, final VDragEvent event) {
        Command checkCriteria = new Command() {
            @Override
            public void execute() {
                acceptCriteria.accept(event, criterioUIDL, cb);
            }
        };

        VDragAndDropManager.get().executeWhenReady(checkCriteria);
    }

    boolean validated = false;

    /**
     * The default implemmentation visits server if {@link AcceptCriterion}
     * can't be verified on client or if {@link AcceptCriterion} are met on
     * client.
     */
    @Override
    public boolean drop(VDragEvent drag) {
        if (acceptCriteria.needsServerSideCheck(drag, criterioUIDL)) {
            return true;
        } else {
            validated = false;
            acceptCriteria.accept(drag, criterioUIDL, new VAcceptCallback() {
                @Override
                public void accepted(VDragEvent event) {
                    validated = true;
                }
            });
            return validated;
        }

    }

    /**
     * Returns the Paintable who owns this {@link VAbstractDropHandler}. Server
     * side counterpart of the Paintable is expected to implement
     * {@link DropTarget} interface.
     */
    @Override
    public abstract ComponentConnector getConnector();

}
