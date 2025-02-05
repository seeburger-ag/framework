/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.ui;

import org.jsoup.nodes.Element;

import com.vaadin.data.Property;
import com.vaadin.shared.ui.progressindicator.ProgressBarState;
import com.vaadin.ui.declarative.DesignAttributeHandler;
import com.vaadin.ui.declarative.DesignContext;

/**
 * Shows the current progress of a long running task.
 * <p>
 * The default mode is to show the current progress internally represented by a
 * floating point value between 0 and 1 (inclusive). The progress bar can also
 * be in an indeterminate mode showing an animation indicating that the task is
 * running but without providing any information about the current progress.
 *
 * @since 7.1
 * @author Vaadin Ltd
 */
public class ProgressBar extends AbstractField<Float>
        implements Property.Viewer, Property.ValueChangeListener {

    private static final float DEFAULT_VALUE = 0f;

    /**
     * Creates a new progress bar initially set to 0% progress.
     */
    public ProgressBar() {
        this(DEFAULT_VALUE);
    }

    /**
     * Creates a new progress bar with the given initial value.
     *
     * @param progress
     *            the initial progress value
     */
    public ProgressBar(float progress) {
        setValue(Float.valueOf(progress));
    }

    /**
     * Creates a new progress bar bound to the given data source.
     *
     * @param dataSource
     *            the property to bind this progress bar to
     */
    public ProgressBar(Property<?> dataSource) {
        setPropertyDataSource(dataSource);
    }

    @Override
    public void beforeClientResponse(boolean initial) {
        super.beforeClientResponse(initial);

        // Update value in state even if the property hasn't fired any event
        getState().state = getValue();
    }

    /**
     * Gets the value of this progress bar. The value is a <code>float</code>
     * between 0 and 1 where 0 represents no progress at all and 1 represents
     * fully completed.
     *
     * @return the current progress value
     */
    @Override
    public Float getValue() {
        return super.getValue();
    }

    /**
     * Sets the value of this progress bar. The value is a <code>float</code>
     * between 0 and 1 where 0 represents no progress at all and 1 represents
     * fully completed.
     *
     * @param newValue
     *            the current progress value
     */
    @Override
    public void setValue(Float newValue) {
        super.setValue(newValue);
    }

    @Override
    public Class<Float> getType() {
        return Float.class;
    }

    @Override
    protected ProgressBarState getState() {
        return (ProgressBarState) super.getState();
    }

    @Override
    protected ProgressBarState getState(boolean markAsDirty) {
        return (ProgressBarState) super.getState(markAsDirty);
    }

    /**
     * Sets whether or not this progress indicator is indeterminate. In
     * indeterminate mode there is an animation indicating that the task is
     * running but without providing any information about the current progress.
     *
     * @param indeterminate
     *            <code>true</code> to set to indeterminate mode; otherwise
     *            <code>false</code>
     */
    public void setIndeterminate(boolean indeterminate) {
        getState().indeterminate = indeterminate;
    }

    /**
     * Gets whether or not this progress indicator is indeterminate. In
     * indeterminate mode there is an animation indicating that the task is
     * running but without providing any information about the current progress.
     *
     * @return <code>true</code> if set to indeterminate mode; otherwise
     *         <code>false</code>
     */
    public boolean isIndeterminate() {
        return getState(false).indeterminate;
    }

    /*
     * Overridden to keep the shared state in sync with the AbstractField
     * internal value. Should be removed once AbstractField is refactored to use
     * shared state.
     *
     * See tickets #10921 and #11064.
     */
    @Override
    protected void setInternalValue(Float newValue) {
        super.setInternalValue(newValue);
        if (newValue == null) {
            newValue = Float.valueOf(0);
        }
        getState().state = newValue;
    }

    @Override
    public void readDesign(Element design, DesignContext designContext) {
        super.readDesign(design, designContext);
        if (design.hasAttr("value") && !design.attr("value").isEmpty()) {
            setValue(DesignAttributeHandler.readAttribute("value",
                    design.attributes(), Float.class), false, true);
        }
    }

    @Override
    public void writeDesign(Element design, DesignContext designContext) {
        super.writeDesign(design, designContext);
        Float defaultValue = ((ProgressBar) designContext
                .getDefaultInstance(this)).getValue();
        DesignAttributeHandler.writeAttribute("value", design.attributes(),
                getValue(), defaultValue, Float.class);
    }

    @Override
    public void clear() {
        setValue(DEFAULT_VALUE);
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty() || getValue() == DEFAULT_VALUE;

    }
}
