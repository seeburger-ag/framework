/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.impl.FocusImpl;

/**
 * A panel that contains an always visible 0x0 size element that holds the focus
 */
public class FocusElementPanel extends SimpleFocusablePanel {

    private DivElement focusElement;

    public FocusElementPanel() {
        focusElement = Document.get().createDivElement();
    }

    @Override
    public void setWidget(Widget w) {
        super.setWidget(w);
        if (focusElement.getParentElement() == null) {
            Style style = focusElement.getStyle();
            style.setPosition(Position.FIXED);
            style.setTop(0, Unit.PX);
            style.setLeft(0, Unit.PX);
            getElement().appendChild(focusElement);
            /* Sink from focusElement too as focus and blur don't bubble */
            DOM.sinkEvents(focusElement, Event.FOCUSEVENTS);
            // revert to original, not focusable
            getElement().setPropertyObject("tabIndex", null);
        } else {
            moveFocusElementAfterWidget();
        }
    }

    /**
     * Helper to keep focus element always in domChild[1]. Aids testing.
     */
    private void moveFocusElementAfterWidget() {
        getElement().insertAfter(focusElement, getWidget().getElement());
    }

    @Override
    public void setFocus(boolean focus) {
        if (focus) {
            FocusImpl.getFocusImplForPanel().focus(focusElement);
        } else {
            FocusImpl.getFocusImplForPanel().blur(focusElement);
        }
    }

    @Override
    public void setTabIndex(int tabIndex) {
        getElement().setTabIndex(-1);
        if (focusElement != null) {
            focusElement.setTabIndex(tabIndex);
        }
    }

    /**
     * @return the focus element
     */
    public com.google.gwt.user.client.Element getFocusElement() {
        return focusElement.cast();
    }
}
