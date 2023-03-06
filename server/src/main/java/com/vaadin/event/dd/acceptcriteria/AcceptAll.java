/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
/**
 *
 */
package com.vaadin.event.dd.acceptcriteria;

import com.vaadin.event.dd.DragAndDropEvent;

/**
 * Criterion that accepts all drops anywhere on the component.
 * <p>
 * Note! Class is singleton, use {@link #get()} method to get the instance.
 *
 *
 * @since 6.3
 *
 */
public final class AcceptAll extends ClientSideCriterion {

    private static final long serialVersionUID = 7406683402153141461L;
    private static AcceptCriterion singleton = new AcceptAll();

    private AcceptAll() {
    }

    public static AcceptCriterion get() {
        return singleton;
    }

    @Override
    public boolean accept(DragAndDropEvent dragEvent) {
        return true;
    }
}
