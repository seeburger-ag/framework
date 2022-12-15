/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.client.ui;

import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.shared.ui.Orientation;

public class VSplitPanelVertical extends VAbstractSplitPanel {

    public VSplitPanelVertical() {
        super(Orientation.VERTICAL);
    }

    @Override
    protected void startResize() {
        if (getFirstWidget() != null && isWidgetFullHeight(getFirstWidget())) {
            getFirstContainer().getStyle().setOverflow(Overflow.HIDDEN);
        }

        if (getSecondWidget() != null
                && isWidgetFullHeight(getSecondWidget())) {
            getSecondContainer().getStyle().setOverflow(Overflow.HIDDEN);
        }
    }

    @Override
    protected void stopResize() {
        getFirstContainer().getStyle().clearOverflow();
        getSecondContainer().getStyle().clearOverflow();
    }

    private boolean isWidgetFullHeight(Widget w) {
        return w.getElement().getStyle().getHeight().equals("100%");
    }
}
