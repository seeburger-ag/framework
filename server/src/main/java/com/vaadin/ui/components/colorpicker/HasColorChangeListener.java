/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.ui.components.colorpicker;

import java.io.Serializable;

public interface HasColorChangeListener extends Serializable {

    /**
     * Adds a {@link ColorChangeListener} to the component.
     *
     * @param listener
     */
    void addColorChangeListener(ColorChangeListener listener);

    /**
     * Removes a {@link ColorChangeListener} from the component.
     *
     * @param listener
     */
    void removeColorChangeListener(ColorChangeListener listener);

}
