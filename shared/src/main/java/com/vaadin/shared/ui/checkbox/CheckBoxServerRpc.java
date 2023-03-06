/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.checkbox;

import com.vaadin.shared.MouseEventDetails;
import com.vaadin.shared.annotations.Delayed;
import com.vaadin.shared.communication.ServerRpc;

public interface CheckBoxServerRpc extends ServerRpc {
    @Delayed
    public void setChecked(boolean checked,
            MouseEventDetails mouseEventDetails);
}
