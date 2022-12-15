/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui;

import com.vaadin.client.StyleConstants;
import com.vaadin.shared.AbstractFieldState;

public abstract class AbstractFieldConnector
        extends AbstractComponentConnector {

    @Override
    public AbstractFieldState getState() {
        return (AbstractFieldState) super.getState();
    }

    @Override
    public boolean isReadOnly() {
        return super.isReadOnly() || getState().propertyReadOnly;
    }

    public boolean isModified() {
        return getState().modified;
    }

    /**
     * Checks whether the required indicator should be shown for the field.
     *
     * Required indicators are hidden if the field or its data source is
     * read-only.
     *
     * @return true if required indicator should be shown
     */
    public boolean isRequired() {
        return getState().required && !isReadOnly();
    }

    @Override
    protected void updateWidgetStyleNames() {
        super.updateWidgetStyleNames();

        // add / remove modified style name to Fields
        setWidgetStyleName(StyleConstants.MODIFIED, isModified());

        // add / remove error style name to Fields
        setWidgetStyleNameWithPrefix(getWidget().getStylePrimaryName(),
                StyleConstants.REQUIRED_EXT, isRequired());

        getWidget().setStyleName(StyleConstants.REQUIRED, isRequired());
    }
}
