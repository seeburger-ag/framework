/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.server;

import com.vaadin.ui.UI;

public class DefaultUIProvider extends UIProvider {

    @Override
    public Class<? extends UI> getUIClass(UIClassSelectionEvent event) {
        VaadinRequest request = event.getRequest();

        String uiClassName = request.getService().getDeploymentConfiguration()
                .getUIClassName();
        if (uiClassName != null) {
            ClassLoader classLoader = request.getService().getClassLoader();
            try {
                Class<? extends UI> uiClass = Class
                        .forName(uiClassName, true, classLoader)
                        .asSubclass(UI.class);

                return uiClass;
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Could not find UI class", e);
            }
        }

        return null;
    }
}
