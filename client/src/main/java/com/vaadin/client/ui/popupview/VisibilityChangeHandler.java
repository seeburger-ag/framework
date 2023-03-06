/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.popupview;

import com.google.gwt.event.shared.EventHandler;

public interface VisibilityChangeHandler extends EventHandler {

    void onVisibilityChange(VisibilityChangeEvent event);
}
