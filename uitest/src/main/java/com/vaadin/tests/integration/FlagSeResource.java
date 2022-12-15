/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.integration;

import com.vaadin.server.ClassResource;

public class FlagSeResource extends ClassResource {

    public FlagSeResource() {
        super("/"
                + FlagSeResource.class.getName().replace('.', '/').replaceAll(
                        FlagSeResource.class.getSimpleName() + "$", "")
                + "se.gif");

    }
}
