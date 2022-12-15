/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.window;

import com.vaadin.shared.communication.ServerRpc;
import com.vaadin.shared.ui.ClickRpc;

public interface WindowServerRpc extends ClickRpc, ServerRpc {

    public void windowModeChanged(WindowMode newState);

    public void windowMoved(int x, int y);

}
