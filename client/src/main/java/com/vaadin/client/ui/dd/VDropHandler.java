/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.dd;

import com.vaadin.client.ApplicationConnection;
import com.vaadin.client.ComponentConnector;

/**
 * Vaadin Widgets that want to receive something via drag and drop implement
 * this interface.
 */
public interface VDropHandler {

    /**
     * Called by DragAndDropManager when a drag operation is in progress and the
     * cursor enters the area occupied by this Paintable.
     *
     * @param dragEvent
     *            DragEvent which contains the transferable and other
     *            information for the operation
     */
    public void dragEnter(VDragEvent dragEvent);

    /**
     * Called by DragAndDropManager when a drag operation is in progress and the
     * cursor leaves the area occupied by this Paintable.
     *
     * @param dragEvent
     *            DragEvent which contains the transferable and other
     *            information for the operation
     */
    public void dragLeave(VDragEvent dragEvent);

    /**
     * Called by DragAndDropManager when a drag operation was in progress and a
     * drop was performed on this Paintable.
     *
     *
     * @param dragEvent
     *            DragEvent which contains the transferable and other
     *            information for the operation
     *
     * @return true if the Tranferrable of this drag event needs to be sent to
     *         the server, false if drop is rejected or no server side event
     *         should be sent
     */
    public boolean drop(VDragEvent drag);

    /**
     * When drag is over current drag handler.
     *
     * With drag implementation by {@link VDragAndDropManager} will be called
     * when mouse is moved. HTML5 implementations call this continuously even
     * though mouse is not moved.
     *
     * @param currentDrag
     */
    public void dragOver(VDragEvent currentDrag);

    /**
     * Returns the ComponentConnector with which this DropHandler is associated
     */
    public ComponentConnector getConnector();

    /**
     * Returns the application connection to which this {@link VDropHandler}
     * belongs to. DragAndDropManager uses this fucction to send Transferable to
     * server side.
     */
    public ApplicationConnection getApplicationConnection();

}
