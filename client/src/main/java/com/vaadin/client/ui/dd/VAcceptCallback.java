/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.dd;

public interface VAcceptCallback {

    /**
     * This method is called by {@link VDragAndDropManager} if the
     * {@link VDragEvent} is still active. Developer can update for example drag
     * icon or empahsis the target if the target accepts the transferable. If
     * the drag and drop operation ends or the {@link VAbstractDropHandler} has
     * changed before response arrives, the method is never called.
     */
    public void accepted(VDragEvent event);

}
