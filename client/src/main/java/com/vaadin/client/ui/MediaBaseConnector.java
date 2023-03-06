/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui;

import com.vaadin.client.WidgetUtil;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.shared.communication.URLReference;
import com.vaadin.shared.ui.AbstractMediaState;
import com.vaadin.shared.ui.MediaControl;
import com.vaadin.shared.ui.PreloadMode;

public abstract class MediaBaseConnector extends AbstractComponentConnector {

    @Override
    protected void init() {
        super.init();

        registerRpc(MediaControl.class, new MediaControl() {
            @Override
            public void play() {
                getWidget().play();
            }

            @Override
            public void pause() {
                getWidget().pause();
            }
        });
    }

    @Override
    public AbstractMediaState getState() {
        return (AbstractMediaState) super.getState();
    }

    @Override
    public void onStateChanged(StateChangeEvent event) {
        super.onStateChanged(event);

        final VMediaBase widget = getWidget();
        final AbstractMediaState state = getState();

        setAltText(state.altText); // must do before loading sources
        setPreload(state.preload);
        widget.setLoop(state.loop);
        widget.setAutoplay(state.autoplay);
        widget.setMuted(state.muted);
        widget.setControls(state.showControls);

        if (event.hasPropertyChanged("sources")) {
            widget.removeAllSources();
            for (int i = 0; i < state.sources.size(); i++) {
                URLReference source = state.sources.get(i);
                String sourceType = state.sourceTypes.get(i);
                widget.addSource(source.getURL(), sourceType);
            }
            widget.load();
        }
    }

    @Override
    public VMediaBase getWidget() {
        return (VMediaBase) super.getWidget();
    }

    private void setAltText(String altText) {

        if (altText == null || "".equals(altText)) {
            altText = getDefaultAltHtml();
        } else if (!getState().htmlContentAllowed) {
            altText = WidgetUtil.escapeHTML(altText);
        }
        getWidget().setAltText(altText);
    }

    private void setPreload(final PreloadMode preload) {
        if (preload != null) {
            getWidget().setPreload(preload.getValue());
        }
    }

    /**
     * @return the default HTML to show users with browsers that do not support
     *         HTML5 media markup.
     */
    protected abstract String getDefaultAltHtml();

}
