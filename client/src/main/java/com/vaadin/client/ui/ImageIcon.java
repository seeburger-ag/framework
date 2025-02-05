/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.client.ui;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.vaadin.client.BrowserInfo;

/**
 * A image based implementation of {@link Icon}.
 * <p>
 * The image is loaded from the given URL ( {@link #setUri(String)}) and
 * displayed in full.
 * </p>
 *
 * @author Vaadin Ltd
 */
public class ImageIcon extends Icon {
    public static final String CLASSNAME = "v-icon";

    public ImageIcon() {
        setElement(DOM.createImg());
        setStyleName(CLASSNAME);
    }

    @Override
    public void setUri(final String imageUrl) {
        /*
         * Start sinking onload events, widgets responsibility to react. We must
         * do this BEFORE we set src as IE fires the event immediately if the
         * image is found in cache (#2592).
         */
        sinkEvents(Event.ONLOAD);

        if (BrowserInfo.get().isIE()) {
            // apply src later for IE, to ensure onload is fired
            Scheduler.get().scheduleDeferred(new ScheduledCommand() {
                @Override
                public void execute() {
                    DOM.setElementProperty(getElement(), "src", imageUrl);
                }
            });
        }

        DOM.setElementProperty(getElement(), "src", imageUrl);

    }

    @Override
    public void setAlternateText(String alternateText) {
        getElement().setAttribute("alt",
                alternateText == null ? "" : alternateText);
    }

    @Override
    public String getUri() {
        return DOM.getElementProperty(getElement(), "src");
    }

}
