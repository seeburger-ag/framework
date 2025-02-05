/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.ui;

import com.vaadin.data.BufferedValidatable;
import com.vaadin.data.Property;
import com.vaadin.ui.Component.Focusable;

/**
 * Field interface is implemented by all classes (field components) that have a
 * value that the user can change through the user interface.
 *
 * Field components are built upon the framework defined in the Field interface
 * and the {@link AbstractField} base class.
 *
 * The Field interface inherits the {@link Component} superinterface and also
 * the {@link Property} interface to have a value for the field.
 *
 * @author Vaadin Ltd.
 *
 * @param <T>
 *            the type of values in the field, which might not be the same type
 *            as that of the data source if converters are used
 */
public interface Field<T> extends Component, BufferedValidatable, Property<T>,
        Property.ValueChangeNotifier, Property.ValueChangeListener,
        Property.Editor, Focusable {

    /**
     * Is this field required.
     *
     * Required fields must filled by the user.
     *
     * @return <code>true</code> if the field is required,otherwise
     *         <code>false</code>.
     * @since 3.1
     */
    public boolean isRequired();

    /**
     * Sets the field required. Required fields must filled by the user.
     *
     * @param required
     *            Is the field required.
     * @since 3.1
     */
    public void setRequired(boolean required);

    /**
     * Sets the error message to be displayed if a required field is empty.
     *
     * @param requiredMessage
     *            Error message.
     * @since 5.2.6
     */
    public void setRequiredError(String requiredMessage);

    /**
     * Gets the error message that is to be displayed if a required field is
     * empty.
     *
     * @return Error message.
     * @since 5.2.6
     */
    public String getRequiredError();

    /**
     * An <code>Event</code> object specifying the Field whose value has been
     * changed.
     *
     * @author Vaadin Ltd.
     * @since 3.0
     */
    @SuppressWarnings("serial")
    public static class ValueChangeEvent extends Component.Event
            implements Property.ValueChangeEvent {

        /**
         * Constructs a new event object with the specified source field object.
         *
         * @param source
         *            the field that caused the event.
         */
        public ValueChangeEvent(Field source) {
            super(source);
        }

        /**
         * Gets the Property which triggered the event.
         *
         * @return the Source Property of the event.
         */
        @Override
        public Property getProperty() {
            return (Property) getSource();
        }
    }

    /**
     * Is the field empty?
     *
     * In general, "empty" state is same as null. As an exception, TextField
     * also treats empty string as "empty".
     *
     * @since 7.4
     * @return true if the field is empty, false otherwise
     */
    public boolean isEmpty();

    /**
     * Clears the value of the field.
     * <p>
     * The field value is typically reset to the initial value of the field.
     * Calling {@link #isEmpty()} on a cleared field must always returns true.
     *
     * @since 7.4
     */
    public void clear();

}
