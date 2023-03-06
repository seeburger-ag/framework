/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.shared.ui.ui;

import com.vaadin.shared.annotations.NoLayout;
import com.vaadin.shared.communication.ClientRpc;

public interface ScrollClientRpc extends ClientRpc {

    @NoLayout
    public void setScrollTop(int scrollTop);

    @NoLayout
    public void setScrollLeft(int scrollLeft);
}
