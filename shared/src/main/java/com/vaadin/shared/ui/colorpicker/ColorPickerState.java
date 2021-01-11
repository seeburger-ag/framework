/*
 * Copyright 2000-2020 Vaadin Ltd.
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
package com.vaadin.shared.ui.colorpicker;

import com.vaadin.shared.AbstractComponentState;
import com.vaadin.shared.annotations.DelegateToWidget;

/**
 * Default shared state implementation for AbstractColorPicker.
 *
 * @since 7.0.0
 */
public class ColorPickerState extends AbstractComponentState {
    {
        primaryStyleName = "v-colorpicker";
    }

    @DelegateToWidget("setOpen")
    public boolean popupVisible = false;

    @DelegateToWidget("setColor")
    public String color = null;

    public boolean showDefaultCaption;

}
