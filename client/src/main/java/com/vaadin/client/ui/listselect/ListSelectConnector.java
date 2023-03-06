/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.client.ui.listselect;

import com.vaadin.client.ui.VListSelect;
import com.vaadin.client.ui.optiongroup.OptionGroupBaseConnector;
import com.vaadin.shared.ui.Connect;
import com.vaadin.ui.ListSelect;

@Connect(ListSelect.class)
public class ListSelectConnector extends OptionGroupBaseConnector {

    @Override
    public VListSelect getWidget() {
        return (VListSelect) super.getWidget();
    }
}
