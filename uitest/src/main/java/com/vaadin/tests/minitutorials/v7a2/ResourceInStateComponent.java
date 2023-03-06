/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.minitutorials.v7a2;

import com.vaadin.server.Resource;
import com.vaadin.ui.AbstractComponent;

public class ResourceInStateComponent extends AbstractComponent {

    public void setMyIcon(Resource icon) {
        setResource("myIcon", icon);
    }

    public Resource getMyIcon() {
        return getResource("myIcon");
    }
}
