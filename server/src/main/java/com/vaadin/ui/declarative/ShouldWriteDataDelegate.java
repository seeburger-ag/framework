/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.ui.declarative;

import java.io.Serializable;

import com.vaadin.ui.Component;

/**
 * Delegate used by {@link DesignContext} to determine whether container data
 * should be written out for a component.
 *
 * @see DesignContext#shouldWriteData(Component)
 *
 * @since 7.5.0
 * @author Vaadin Ltd
 */
public interface ShouldWriteDataDelegate extends Serializable {

    /**
     * The default delegate implementation that assumes that all component data
     * is provided by a data source connected to a back end system and that the
     * data should thus not be written.
     */
    public static final ShouldWriteDataDelegate DEFAULT = new ShouldWriteDataDelegate() {
        @Override
        public boolean shouldWriteData(Component component) {
            return false;
        }
    };

    /**
     * Determines whether the container data of a component should be written
     * out.
     *
     * @param component
     *            the component to check
     * @return <code>true</code> if container data should be written out for the
     *         provided component; otherwise <code>false</code>.
     */
    boolean shouldWriteData(Component component);
}
