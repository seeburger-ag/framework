/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.client.ui.twincolselect;

import com.vaadin.client.ApplicationConnection;
import com.vaadin.client.DirectionalManagedLayout;
import com.vaadin.client.UIDL;
import com.vaadin.client.ui.VTwinColSelect;
import com.vaadin.client.ui.optiongroup.OptionGroupBaseConnector;
import com.vaadin.shared.ui.Connect;
import com.vaadin.shared.ui.twincolselect.TwinColSelectState;
import com.vaadin.ui.TwinColSelect;

@Connect(TwinColSelect.class)
public class TwinColSelectConnector extends OptionGroupBaseConnector
        implements DirectionalManagedLayout {

    @Override
    public void updateFromUIDL(UIDL uidl, ApplicationConnection client) {
        // Captions are updated before super call to ensure the widths are set
        // correctly
        if (isRealUpdate(uidl)) {
            getWidget().updateCaptions(uidl);
            getLayoutManager().setNeedsHorizontalLayout(this);
        }

        super.updateFromUIDL(uidl, client);
    }

    @Override
    protected void init() {
        super.init();
        getLayoutManager().registerDependency(this,
                getWidget().captionWrapper.getElement());
    }

    @Override
    public void onUnregister() {
        getLayoutManager().unregisterDependency(this,
                getWidget().captionWrapper.getElement());
    }

    @Override
    public VTwinColSelect getWidget() {
        return (VTwinColSelect) super.getWidget();
    }

    @Override
    public TwinColSelectState getState() {
        return (TwinColSelectState) super.getState();
    }

    @Override
    public void layoutVertically() {
        if (isUndefinedHeight()) {
            getWidget().clearInternalHeights();
        } else {
            getWidget().setInternalHeights();
        }
    }

    @Override
    public void layoutHorizontally() {
        if (isUndefinedWidth()) {
            getWidget().clearInternalWidths();
        } else {
            getWidget().setInternalWidths();
        }
    }
}
