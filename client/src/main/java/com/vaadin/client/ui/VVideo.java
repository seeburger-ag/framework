/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.client.ui;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.dom.client.VideoElement;
import com.vaadin.client.Util;

public class VVideo extends VMediaBase {

    public static String CLASSNAME = "v-video";

    private VideoElement video;

    public VVideo() {
        video = Document.get().createVideoElement();
        setMediaElement(video);
        setStyleName(CLASSNAME);

        updateDimensionsWhenMetadataLoaded(getElement());
    }

    /**
     * Registers a listener that updates the dimensions of the widget when the
     * video metadata has been loaded.
     *
     * @param el
     */
    private native void updateDimensionsWhenMetadataLoaded(Element el)
    /*-{
              var self = this;
              el.addEventListener('loadedmetadata', $entry(function(e) {
                  self.@com.vaadin.client.ui.VVideo::updateElementDynamicSize(II)(el.videoWidth, el.videoHeight);
              }), false);

    }-*/;

    /**
     * Updates the dimensions of the widget.
     *
     * @param w
     * @param h
     */
    private void updateElementDynamicSize(int w, int h) {
        video.getStyle().setWidth(w, Unit.PX);
        video.getStyle().setHeight(h, Unit.PX);
        Util.notifyParentOfSizeChange(this, true);
    }

    public void setPoster(String poster) {
        video.setPoster(poster);
    }

}
