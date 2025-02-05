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
import com.google.gwt.dom.client.MediaElement;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.dom.client.SourceElement;
import com.google.gwt.dom.client.Text;
import com.google.gwt.user.client.ui.Widget;

public abstract class VMediaBase extends Widget {

    private MediaElement media;
    private Text altText;

    /**
     * Sets the MediaElement that is to receive all commands and properties.
     *
     * @param element
     */
    public void setMediaElement(MediaElement element) {
        setElement(element);
        media = element;
    }

    public void play() {
        media.play();
    }

    public void pause() {
        media.pause();
    }

    public void setAltText(String alt) {
        if (altText == null) {
            altText = Document.get().createTextNode(alt);
            media.appendChild(altText);
        } else {
            altText.setNodeValue(alt);
        }
    }

    public void setControls(boolean shouldShowControls) {
        media.setControls(shouldShowControls);
    }

    public void setAutoplay(boolean shouldAutoplay) {
        media.setAutoplay(shouldAutoplay);
    }

    public void setMuted(boolean mediaMuted) {
        media.setMuted(mediaMuted);
    }

    /**
     * Sets the preload attribute that is intended to provide a hint to the
     * browser how the media should be preloaded. See
     * AbstractMedia.setPreload(PreloadMode) and PreloadMode for more
     * information.
     *
     * @param preload
     *            preload mode
     * @since 7.7.11
     */
    public void setPreload(final String preload) {
        media.setPreload(preload);
    }

    /**
     * Enables or disables looping.
     *
     * @param loop
     *            if true, enable looping
     * @since 7.7.11
     */
    public void setLoop(final boolean loop) {
        media.setLoop(loop);
    }

    public void removeAllSources() {
        NodeList<com.google.gwt.dom.client.Element> l = media
                .getElementsByTagName(SourceElement.TAG);
        for (int i = l.getLength() - 1; i >= 0; i--) {
            media.removeChild(l.getItem(i));
        }

    }

    public void load() {
        media.load();
    }

    public void addSource(String sourceUrl, String sourceType) {
        Element src = Document.get().createElement(SourceElement.TAG);
        src.setAttribute("src", sourceUrl);
        src.setAttribute("type", sourceType);
        media.appendChild(src);
    }
}
