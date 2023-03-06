/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.label;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.PreElement;
import com.vaadin.client.Profiler;
import com.vaadin.client.WidgetUtil;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.client.ui.VLabel;
import com.vaadin.shared.ui.Connect;
import com.vaadin.shared.ui.Connect.LoadStyle;
import com.vaadin.shared.ui.label.LabelState;
import com.vaadin.ui.Label;

@Connect(value = Label.class, loadStyle = LoadStyle.EAGER)
public class LabelConnector extends AbstractComponentConnector {

    @Override
    public LabelState getState() {
        return (LabelState) super.getState();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        boolean sinkOnloads = false;
        Profiler.enter("LabelConnector.onStateChanged update content");
        switch (getState().contentMode) {
        case PREFORMATTED:
            PreElement preElement = Document.get().createPreElement();
            preElement.setInnerText(getState().text);
            // clear existing content
            getWidget().setHTML("");
            // add preformatted text to dom
            getWidget().getElement().appendChild(preElement);
            break;

        case TEXT:
            getWidget().setText(getState().text);
            break;

        case HTML:
        case RAW:
            sinkOnloads = true;
        case XML:
            getWidget().setHTML(getState().text);
            break;
        default:
            getWidget().setText("");
            break;

        }
        Profiler.leave("LabelConnector.onStateChanged update content");

        if (sinkOnloads) {
            Profiler.enter("LabelConnector.onStateChanged sinkOnloads");
            WidgetUtil.sinkOnloadForImages(getWidget().getElement());
            Profiler.leave("LabelConnector.onStateChanged sinkOnloads");
        }
    }

    @Override
    public VLabel getWidget() {
        return (VLabel) super.getWidget();
    }

}
