/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.flash;

import com.google.gwt.dom.client.Element;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.client.ui.VFlash;
import com.vaadin.client.ui.layout.ElementResizeEvent;
import com.vaadin.client.ui.layout.ElementResizeListener;
import com.vaadin.shared.ui.AbstractEmbeddedState;
import com.vaadin.shared.ui.Connect;
import com.vaadin.shared.ui.flash.FlashState;

@Connect(com.vaadin.ui.Flash.class)
public class FlashConnector extends AbstractComponentConnector {

    @Override
    public VFlash getWidget() {
        return (VFlash) super.getWidget();
    }

    @Override
    public FlashState getState() {
        return (FlashState) super.getState();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {

        super.onStateChanged(stateChangeEvent);
        getWidget().setSource(
                getResourceUrl(AbstractEmbeddedState.SOURCE_RESOURCE));
        getWidget().setArchive(getState().archive);
        getWidget().setClassId(getState().classId);
        getWidget().setCodebase(getState().codebase);
        getWidget().setCodetype(getState().codetype);
        getWidget().setStandby(getState().standby);
        getWidget().setAlternateText(getState().alternateText);
        getWidget().setEmbedParams(getState().embedParams);

        getWidget().rebuildIfNeeded();
    }

    private final ElementResizeListener listener = new ElementResizeListener() {
        public void onElementResize(ElementResizeEvent e) {
            Element slot = e.getElement().getParentElement();
            getWidget().setSlotHeightAndWidth(slot.getOffsetHeight(),
                    slot.getOffsetWidth());
        }
    };

    @Override
    protected void init() {
        super.init();
        getLayoutManager().addElementResizeListener(getWidget().getElement(),
                listener);
    }

    @Override
    public void onUnregister() {
        getLayoutManager().removeElementResizeListener(getWidget().getElement(),
                listener);
    }

}
