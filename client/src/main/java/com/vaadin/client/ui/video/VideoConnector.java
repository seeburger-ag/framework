/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.video;

import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.MediaBaseConnector;
import com.vaadin.client.ui.VVideo;
import com.vaadin.shared.ui.Connect;
import com.vaadin.shared.ui.video.VideoConstants;
import com.vaadin.shared.ui.video.VideoState;
import com.vaadin.ui.Video;

@Connect(Video.class)
public class VideoConnector extends MediaBaseConnector {

    @Override
    public VideoState getState() {
        return (VideoState) super.getState();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);

        String resourceUrl = getResourceUrl(VideoConstants.POSTER_RESOURCE);
        if (resourceUrl != null) {
            getWidget().setPoster(resourceUrl);
        }
    }

    @Override
    public VVideo getWidget() {
        return (VVideo) super.getWidget();
    }

    @Override
    protected String getDefaultAltHtml() {
        return "Your browser does not support the <code>video</code> element.";
    }

}
