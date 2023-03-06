/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.client.ui.nativeselect;

import com.vaadin.client.ui.ConnectorFocusAndBlurHandler;
import com.vaadin.client.ui.VNativeSelect;
import com.vaadin.client.ui.optiongroup.OptionGroupBaseConnector;
import com.vaadin.shared.ui.Connect;
import com.vaadin.ui.NativeSelect;

@Connect(NativeSelect.class)
public class NativeSelectConnector extends OptionGroupBaseConnector {

    @Override
    protected void init() {
        super.init();
        ConnectorFocusAndBlurHandler.addHandlers(this, getWidget().getSelect());
    }

    @Override
    public VNativeSelect getWidget() {
        return (VNativeSelect) super.getWidget();
    }
}
