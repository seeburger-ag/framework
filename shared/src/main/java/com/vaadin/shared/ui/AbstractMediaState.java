/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.ui;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.shared.AbstractComponentState;
import com.vaadin.shared.annotations.NoLayout;
import com.vaadin.shared.communication.URLReference;

public class AbstractMediaState extends AbstractComponentState {
    public boolean showControls;

    @NoLayout
    public String altText;

    public boolean htmlContentAllowed;

    @NoLayout
    public boolean autoplay;

    @NoLayout
    public boolean muted;

    /**
     * Preload mode for the media.
     *
     * @since 7.7.11
     */
    @NoLayout
    public PreloadMode preload;

    /**
     * Looping of media active (true) or not.
     *
     * @since 7.7.11
     */
    @NoLayout
    public boolean loop;

    public List<URLReference> sources = new ArrayList<URLReference>();

    public List<String> sourceTypes = new ArrayList<String>();
}
