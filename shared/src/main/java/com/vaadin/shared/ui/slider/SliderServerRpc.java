/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui.slider;

import com.vaadin.shared.communication.ServerRpc;

public interface SliderServerRpc extends ServerRpc {

    /**
     * Invoked when the value of a variable has changed. Slider listeners are
     * notified if the slider value has changed.
     *
     * @param value
     */
    public void valueChanged(double value);
}
