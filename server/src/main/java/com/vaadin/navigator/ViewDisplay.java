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

/**
 * Interface for displaying a view in an appropriate location.
 *
 * The view display can be a component/layout itself or can modify a separate
 * layout.
 *
 * @author Vaadin Ltd
 * @since 7.0
 */
public interface ViewDisplay extends Serializable {
    /**
     * Remove previously shown view and show the newly selected view in its
     * place.
     *
     * The parameters for the view have been set before this method is called.
     *
     * @param view
     *            new view to show
     */
    public void showView(View view);
}
