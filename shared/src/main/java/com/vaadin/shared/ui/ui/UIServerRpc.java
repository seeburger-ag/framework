/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.ui;

import com.vaadin.shared.annotations.NoLoadingIndicator;
import com.vaadin.shared.annotations.Delayed;
import com.vaadin.shared.communication.ServerRpc;
import com.vaadin.shared.ui.ClickRpc;

public interface UIServerRpc extends ClickRpc, ServerRpc {
    @Delayed(lastOnly = true)
    public void resize(int viewWidth, int viewHeight, int windowWidth,
            int windowHeight);

    @Delayed(lastOnly = true)
    public void scroll(int scrollTop, int scrollLeft);

    @NoLoadingIndicator
    @Delayed(lastOnly = true)
    /*
     * @Delayed just to get lastOnly semantics, sendPendingVariableChanges()
     * should always be called to ensure the message is flushed right away.
     */
    public void poll();
}
