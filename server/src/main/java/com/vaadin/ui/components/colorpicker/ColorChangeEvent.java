/*
 * Copyright 2000-2022 Vaadin Ltd.
 *
 * Licensed under the Commercial Vaadin Developer License version 4.0 (CVDLv4);
 * you may not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 * https://vaadin.com/license/cvdl-4.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.ui.components.colorpicker;

import com.vaadin.shared.ui.colorpicker.Color;
import com.vaadin.ui.Component;
import com.vaadin.ui.Component.Event;

/**
 * The color changed event which is passed to the listeners when a color change
 * occurs.
 *
 * @since 7.0.0
 */
public class ColorChangeEvent extends Event {
    private final Color color;

    public ColorChangeEvent(Component source, Color color) {
        super(source);

        this.color = color;
    }

    /**
     * Returns the new color.
     */
    public Color getColor() {
        return color;
    }
}
