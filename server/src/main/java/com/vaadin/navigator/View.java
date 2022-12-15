/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.navigator;

import java.io.Serializable;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Component;

/**
 * Interface for all views controlled by the navigator.
 *
 * Each view added to the navigator must implement this interface. Typically, a
 * view is a {@link Component}.
 *
 * @author Vaadin Ltd
 * @since 7.0
 */
public interface View extends Serializable {

    /**
     * This view is navigated to.
     *
     * This method is always called before the view is shown on screen.
     * {@link ViewChangeEvent#getParameters() event.getParameters()} may contain
     * extra parameters relevant to the view.
     *
     * @param event
     *            ViewChangeEvent representing the view change that is
     *            occurring. {@link ViewChangeEvent#getNewView()
     *            event.getNewView()} returns <code>this</code>.
     *
     */
    public void enter(ViewChangeEvent event);
}
