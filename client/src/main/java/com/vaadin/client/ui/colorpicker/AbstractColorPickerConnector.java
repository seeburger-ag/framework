/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.colorpicker;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.colorpicker.ColorPickerState;

/**
 * An abstract class that defines default implementation for a color picker
 * connector.
 *
 * @since 7.0.0
 */
public abstract class AbstractColorPickerConnector
        extends AbstractComponentConnector implements ClickHandler {

    private static final String DEFAULT_WIDTH_STYLE = "v-default-caption-width";

    @Override
    public ColorPickerState getState() {
        return (ColorPickerState) super.getState();
    }

    @Override
    public boolean delegateCaptionHandling() {
        return false;
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        // NOTE: this method is called after @DelegateToWidget
        super.onStateChanged(stateChangeEvent);
        if (stateChangeEvent.hasPropertyChanged("color")) {
            refreshColor();

            if (getState().showDefaultCaption && (getState().caption == null
                    || "".equals(getState().caption))) {

                setCaption(getState().color);
            }
        }
        if (stateChangeEvent.hasPropertyChanged("caption")
                || stateChangeEvent.hasPropertyChanged("htmlContentAllowed")
                || stateChangeEvent.hasPropertyChanged("showDefaultCaption")) {

            setCaption(getCaption());
            refreshDefaultCaptionStyle();
        }
    }

    @Override
    public void init() {
        super.init();
        if (getWidget() instanceof HasClickHandlers) {
            ((HasClickHandlers) getWidget()).addClickHandler(this);
        }
    }

    /**
     * Get caption for the color picker widget.
     *
     * @return
     */
    protected String getCaption() {
        if (getState().showDefaultCaption && (getState().caption == null
                || "".equals(getState().caption))) {
            return getState().color;
        }
        return getState().caption;
    }

    /**
     * Add/remove default caption style.
     */
    protected void refreshDefaultCaptionStyle() {
        if (getState().showDefaultCaption
                && (getState().caption == null || getState().caption.isEmpty())
                && getState().width.isEmpty()) {
            getWidget().addStyleName(DEFAULT_WIDTH_STYLE);
        } else {
            getWidget().removeStyleName(DEFAULT_WIDTH_STYLE);
        }
    }

    /**
     * Set caption of the color picker widget.
     *
     * @param caption
     */
    protected abstract void setCaption(String caption);

    /**
     * Update the widget to show the currently selected color.
     */
    protected abstract void refreshColor();

}
