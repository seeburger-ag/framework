/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client;

import com.vaadin.client.ui.ManagedLayout;
import com.vaadin.client.ui.layout.ElementResizeListener;

/**
 * Connector with layout measuring hint. Used to improve granularity of control
 * over child component measurements.
 *
 * @since 7.6
 * @author Vaadin Ltd
 */
public interface HasChildMeasurementHintConnector
        extends HasComponentsConnector {

    /**
     * Specifies how you would like child components measurements to be handled.
     * Since this is a hint, it can be ignored when deemed necessary.
     */
    public enum ChildMeasurementHint {

        /**
         * Always measure all child components (default).
         */
        MEASURE_ALWAYS,

        /**
         * Measure child component only if child component is a {@link Layout}
         * or implements either {@link ManagedLayout} or
         * {@link ElementResizeListener}.
         */
        MEASURE_IF_NEEDED,

        /**
         * Never measure child components. This can improve rendering speed of
         * components with lots of children (e.g. Table), but can cause some
         * child components to be rendered incorrectly (e.g. ComboBox).
         */
        MEASURE_NEVER
    }

    /**
     * Sets the child measurement hint for this component.
     *
     * @param hint
     *            the value to set
     */
    void setChildMeasurementHint(ChildMeasurementHint hint);

    /**
     * Returns the current child measurement hint value.
     *
     * @return a ChildLayoutMeasureMode value
     */
    ChildMeasurementHint getChildMeasurementHint();

}
