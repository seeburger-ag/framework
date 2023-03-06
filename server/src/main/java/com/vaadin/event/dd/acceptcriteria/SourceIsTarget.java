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

import com.vaadin.event.Transferable;
import com.vaadin.event.TransferableImpl;
import com.vaadin.event.dd.DragAndDropEvent;
import com.vaadin.event.dd.DropTarget;
import com.vaadin.ui.Component;
import com.vaadin.ui.Table;
import com.vaadin.ui.Tree;

/**
 *
 * A criterion that ensures the drag source is the same as drop target. Eg.
 * {@link Tree} or {@link Table} could support only re-ordering of items, but no
 * {@link Transferable}s coming outside.
 * <p>
 * Note! Class is singleton, use {@link #get()} method to get the instance.
 *
 * @since 6.3
 *
 */
public class SourceIsTarget extends ClientSideCriterion {

    private static final long serialVersionUID = -451399314705532584L;
    private static SourceIsTarget instance = new SourceIsTarget();

    private SourceIsTarget() {
    }

    @Override
    public boolean accept(DragAndDropEvent dragEvent) {
        if (dragEvent.getTransferable() instanceof TransferableImpl) {
            Component sourceComponent = ((TransferableImpl) dragEvent
                    .getTransferable()).getSourceComponent();
            DropTarget target = dragEvent.getTargetDetails().getTarget();
            return sourceComponent == target;
        }
        return false;
    }

    public static synchronized SourceIsTarget get() {
        return instance;
    }

}
