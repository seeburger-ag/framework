/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.ui;

import com.vaadin.server.Resource;
import com.vaadin.shared.ui.audio.AudioState;

/**
 * The Audio component translates into an HTML5 &lt;audio&gt; element and as
 * such is only supported in browsers that support HTML5 media markup. Browsers
 * that do not support HTML5 display the text or HTML set by calling
 * {@link #setAltText(String)}.
 *
 * A flash-player fallback can be implemented by setting HTML content allowed (
 * {@link #setHtmlContentAllowed(boolean)} and calling
 * {@link #setAltText(String)} with the flash player markup. An example of flash
 * fallback can be found at the <a href=
 * "https://developer.mozilla.org/En/Using_audio_and_video_in_Firefox#Using_Flash"
 * >Mozilla Developer Network</a>.
 *
 * Multiple sources can be specified. Which of the sources is used is selected
 * by the browser depending on which file formats it supports. See
 * <a href="http://en.wikipedia.org/wiki/HTML5_video#Table">wikipedia</a> for a
 * table of formats supported by different browsers.
 *
 * @author Vaadin Ltd
 * @since 6.7.0
 */
public class Audio extends AbstractMedia {

    public Audio() {
        this("", null);
    }

    /**
     * @param caption
     *            The caption of the audio component.
     */
    public Audio(String caption) {
        this(caption, null);
    }

    /**
     * @param caption
     *            The caption of the audio component
     * @param source
     *            The audio file to play.
     */
    public Audio(String caption, Resource source) {
        setCaption(caption);
        setSource(source);
        setShowControls(true);
    }

    @Override
    protected AudioState getState() {
        return (AudioState) super.getState();
    }
}
