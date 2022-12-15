/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.audio;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.BrowserInfo;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.MediaBaseConnector;
import com.vaadin.client.ui.VAudio;
import com.vaadin.shared.ui.Connect;
import com.vaadin.shared.ui.audio.AudioState;
import com.vaadin.ui.Audio;

@Connect(Audio.class)
public class AudioConnector extends MediaBaseConnector {

    @Override
    protected Widget createWidget() {
        return GWT.create(VAudio.class);
    }

    @Override
    protected String getDefaultAltHtml() {
        return "Your browser does not support the <code>audio</code> element.";
    }

    @Override
    public AudioState getState() {
        return (AudioState) super.getState();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);

        // Opera (12.14) has a bug where an audio element w/o controls is shown
        // as 150x300px, which is not usually desired. However, in order to show
        // the error/alt message, we only do this in the exact situation.
        if (BrowserInfo.get().isOpera()
                && stateChangeEvent.hasPropertyChanged("showControls")) {
            Style style = getWidget().getElement().getStyle();
            if (!getState().showControls) {
                if (isUndefinedHeight() && isUndefinedWidth()
                        && getWidget().getOffsetHeight() == 150
                        && getWidget().getOffsetWidth() == 300) {
                    // only if no size set and 150x300
                    style.setWidth(0, Unit.PX);
                    style.setHeight(0, Unit.PX);
                }
            } else {
                // clear sizes if it's supposed to be undefined
                if (isUndefinedHeight()) {
                    style.clearHeight();
                }
                if (isUndefinedWidth()) {
                    style.clearWidth();
                }
            }
        }
    }

}
