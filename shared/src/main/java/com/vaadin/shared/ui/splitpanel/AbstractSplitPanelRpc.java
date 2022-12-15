/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.splitpanel;

import com.vaadin.shared.MouseEventDetails;
import com.vaadin.shared.communication.ServerRpc;

public interface AbstractSplitPanelRpc extends ServerRpc {

    /**
     * Called when the position has been updated by the user.
     *
     * @param position
     *            The new position in % if the current unit is %, in px
     *            otherwise
     */
    public void setSplitterPosition(float position);

    /**
     * Called when a click event has occurred on the splitter.
     *
     * @param mouseDetails
     *            Details about the mouse when the event took place
     */
    public void splitterClick(MouseEventDetails mouseDetails);

}
