/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.ui;

/**
 * Component with layout measuring hint. Used to improve granularity of control
 * over child component measurements.
 *
 * @since 7.6
 * @author Vaadin Ltd
 */
public interface HasChildMeasurementHint extends HasComponents {

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
         * Measure child component only if child component is a Layout or
         * implements either ManagedLayout or ElementResizeListener.
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
     * Sets desired child size measurement hint.
     *
     * @param hint
     *            desired hint. A value of null will reset value back to the
     *            default (MEASURE_ALWAYS)
     */
    void setChildMeasurementHint(ChildMeasurementHint hint);

    /**
     * Returns the current child size measurement hint.
     *
     * @return a child measurement hint value
     */
    ChildMeasurementHint getChildMeasurementHint();

}
