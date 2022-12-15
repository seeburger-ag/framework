/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.dd;

import com.google.gwt.core.client.GWT;

/**
 * A class via all AcceptCriteria instances are fetched by an identifier.
 */
public class VAcceptCriteria {
    private static VAcceptCriterionFactory impl;

    static {
        impl = GWT.create(VAcceptCriterionFactory.class);
    }

    public static VAcceptCriterion get(String name) {
        return impl.get(name);
    }

}
