/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.client.ui;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.SimplePanel;
import com.vaadin.client.ApplicationConnection;
import com.vaadin.client.Focusable;
import com.vaadin.client.StyleConstants;
import com.vaadin.client.WidgetUtil.ErrorUtil;
import com.vaadin.client.ui.ShortcutActionHandler.ShortcutActionHandlerOwner;
import com.vaadin.client.ui.TouchScrollDelegate.TouchScrollHandler;
import com.vaadin.shared.ui.ErrorLevel;

public class VPanel extends SimplePanel
        implements ShortcutActionHandlerOwner, Focusable {

    public static final String CLASSNAME = "v-panel";

    /** For internal use only. May be removed or replaced in the future. */
    public ApplicationConnection client;

    /** For internal use only. May be removed or replaced in the future. */
    public String id;

    /** For internal use only. May be removed or replaced in the future. */
    public final Element captionNode = DOM.createDiv();

    private final Element captionText = DOM.createSpan();

    private Icon icon;

    /** For internal use only. May be removed or replaced in the future. */
    public final Element bottomDecoration = DOM.createDiv();

    /** For internal use only. May be removed or replaced in the future. */
    public final Element contentNode = DOM.createDiv();

    private Element errorIndicatorElement;

    /** For internal use only. May be removed or replaced in the future. */
    public ShortcutActionHandler shortcutHandler;

    /** For internal use only. May be removed or replaced in the future. */
    public int scrollTop;

    /** For internal use only. May be removed or replaced in the future. */
    public int scrollLeft;

    private TouchScrollHandler touchScrollHandler;

    public VPanel() {
        super();
        DivElement captionWrap = Document.get().createDivElement();
        captionWrap.appendChild(captionNode);
        captionNode.appendChild(captionText);

        captionWrap.setClassName(CLASSNAME + "-captionwrap");
        captionNode.setClassName(CLASSNAME + "-caption");
        contentNode.setClassName(CLASSNAME + "-content");
        bottomDecoration.setClassName(CLASSNAME + "-deco");

        getElement().appendChild(captionWrap);

        /*
         * Make contentNode focusable only by using the setFocus() method. This
         * behaviour can be changed by invoking setTabIndex() in the serverside
         * implementation
         */
        contentNode.setTabIndex(-1);

        getElement().appendChild(contentNode);

        getElement().appendChild(bottomDecoration);
        setStyleName(CLASSNAME);
        DOM.sinkEvents(getElement(), Event.ONKEYDOWN);
        DOM.sinkEvents(contentNode, Event.ONSCROLL | Event.TOUCHEVENTS);

        contentNode.getStyle().setProperty("position", "relative");
        getElement().getStyle().setProperty("overflow", "hidden");

        makeScrollable();
    }

    /**
     * Sets the keyboard focus on the Panel
     *
     * @param focus
     *            Should the panel have focus or not.
     */
    public void setFocus(boolean focus) {
        if (focus) {
            getContainerElement().focus();
        } else {
            getContainerElement().blur();
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.client.Focusable#focus()
     */

    @Override
    public void focus() {
        setFocus(true);

    }

    @Override
    protected com.google.gwt.user.client.Element getContainerElement() {
        return DOM.asOld(contentNode);
    }

    /** For internal use only. May be removed or replaced in the future. */
    public void setCaption(String text, boolean captionAsHtml) {
        if (captionAsHtml) {
            captionText.setInnerHTML(text);
        } else {
            captionText.setInnerText(text);
        }
    }

    /** For internal use only. May be removed or replaced in the future. */
    public void setErrorIndicatorVisible(boolean showError,
            ErrorLevel errorLevel) {
        if (showError) {
            if (errorIndicatorElement == null) {
                errorIndicatorElement = DOM.createSpan();
                DOM.setElementProperty(errorIndicatorElement, "className",
                        StyleConstants.STYLE_NAME_ERROR_INDICATOR);
                DOM.sinkEvents(errorIndicatorElement, Event.MOUSEEVENTS);
                sinkEvents(Event.MOUSEEVENTS);
            }

            ErrorUtil.setErrorLevelStyle(errorIndicatorElement,
                    StyleConstants.STYLE_NAME_ERROR_INDICATOR, errorLevel);

            DOM.insertBefore(captionNode, errorIndicatorElement, captionText);
        } else if (errorIndicatorElement != null) {
            DOM.removeChild(captionNode, errorIndicatorElement);
            errorIndicatorElement = null;
        }
    }

    /** For internal use only. May be removed or replaced in the future. */
    public void setIconUri(String iconUri, ApplicationConnection client) {
        if (icon != null) {
            captionNode.removeChild(icon.getElement());
        }
        icon = client.getIcon(iconUri);
        if (icon != null) {
            DOM.insertChild(captionNode, icon.getElement(), 0);
        }
    }

    @Override
    public void onBrowserEvent(Event event) {
        super.onBrowserEvent(event);

        final int type = DOM.eventGetType(event);
        if (type == Event.ONKEYDOWN && shortcutHandler != null) {
            shortcutHandler.handleKeyboardEvent(event);
            return;
        }
        if (type == Event.ONSCROLL) {
            int newscrollTop = DOM.getElementPropertyInt(contentNode,
                    "scrollTop");
            int newscrollLeft = DOM.getElementPropertyInt(contentNode,
                    "scrollLeft");
            if (client != null && (newscrollLeft != scrollLeft
                    || newscrollTop != scrollTop)) {
                scrollLeft = newscrollLeft;
                scrollTop = newscrollTop;
                client.updateVariable(id, "scrollTop", scrollTop, false);
                client.updateVariable(id, "scrollLeft", scrollLeft, false);
            }
        }
    }

    @Override
    public ShortcutActionHandler getShortcutActionHandler() {
        return shortcutHandler;
    }

    /**
     * Ensures the panel is scrollable eg. after style name changes.
     * <p>
     * For internal use only. May be removed or replaced in the future.
     */
    public void makeScrollable() {
        if (touchScrollHandler == null) {
            touchScrollHandler = TouchScrollDelegate.enableTouchScrolling(this);
        }
        touchScrollHandler.addElement(contentNode);
    }
}
