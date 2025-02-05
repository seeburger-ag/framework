/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.client.ui;

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasEnabled;
import com.vaadin.client.Util;
import com.vaadin.shared.ui.BorderStyle;

public class VLink extends HTML implements ClickHandler, HasEnabled {

    public static final String CLASSNAME = "v-link";

    @Deprecated
    protected static final BorderStyle BORDER_STYLE_DEFAULT = BorderStyle.DEFAULT;

    @Deprecated
    protected static final BorderStyle BORDER_STYLE_MINIMAL = BorderStyle.MINIMAL;

    @Deprecated
    protected static final BorderStyle BORDER_STYLE_NONE = BorderStyle.NONE;

    /** For internal use only. May be removed or replaced in the future. */
    public String src;

    /** For internal use only. May be removed or replaced in the future. */
    public String target;

    /** For internal use only. May be removed or replaced in the future. */
    public BorderStyle borderStyle = BorderStyle.DEFAULT;

    /** For internal use only. May be removed or replaced in the future. */
    public boolean enabled;

    /** For internal use only. May be removed or replaced in the future. */
    public int targetWidth;

    /** For internal use only. May be removed or replaced in the future. */
    public int targetHeight;

    /** For internal use only. May be removed or replaced in the future. */
    public Element errorIndicatorElement;

    /** For internal use only. May be removed or replaced in the future. */
    public final Element anchor = DOM.createAnchor();

    /** For internal use only. May be removed or replaced in the future. */
    public final Element captionElement = DOM.createSpan();

    /** For internal use only. May be removed or replaced in the future. */
    public Icon icon;

    public VLink() {
        super();
        getElement().appendChild(anchor);
        anchor.appendChild(captionElement);
        addClickHandler(this);
        setStyleName(CLASSNAME);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (enabled) {
            if (target == null) {
                target = "_self";
            }
            String features;
            switch (borderStyle) {
            case NONE:
                features = "menubar=no,location=no,status=no";
                break;
            case MINIMAL:
                features = "menubar=yes,location=no,status=no";
                break;
            default:
                features = "";
                break;
            }

            if (targetWidth > 0) {
                features += (features.length() > 0 ? "," : "") + "width="
                        + targetWidth;
            }
            if (targetHeight > 0) {
                features += (features.length() > 0 ? "," : "") + "height="
                        + targetHeight;
            }

            if (features.length() > 0) {
                // if 'special features' are set, use window.open(), unless
                // a modifier key is held (ctrl to open in new tab etc)
                Event e = DOM.eventGetCurrentEvent();
                if (!e.getCtrlKey() && !e.getAltKey() && !e.getShiftKey()
                        && !e.getMetaKey()) {
                    Window.open(src, target, features);
                    e.preventDefault();
                }
            }
        }
    }

    @Override
    public void onBrowserEvent(Event event) {
        final Element target = DOM.eventGetTarget(event);
        if (event.getTypeInt() == Event.ONLOAD) {
            Util.notifyParentOfSizeChange(this, true);
        }
        if (target == captionElement || target == anchor
                || (icon != null && target == icon.getElement())) {
            super.onBrowserEvent(event);
        }
        if (!enabled) {
            event.preventDefault();
        }

    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
