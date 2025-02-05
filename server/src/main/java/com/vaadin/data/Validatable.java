/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.data;

import java.io.Serializable;
import java.util.Collection;

/**
 * <p>
 * Interface for validatable objects. Defines methods to verify if the object's
 * value is valid or not, and to add, remove and list registered validators of
 * the object.
 * </p>
 *
 * @author Vaadin Ltd.
 * @since 3.0
 * @see Validator
 */
public interface Validatable extends Serializable {

    /**
     * <p>
     * Adds a new validator for this object. The validator's
     * {@link Validator#validate(Object)} method is activated every time the
     * object's value needs to be verified, that is, when the {@link #isValid()}
     * method is called. This usually happens when the object's value changes.
     * </p>
     *
     * @param validator
     *            the new validator
     */
    void addValidator(Validator validator);

    /**
     * <p>
     * Removes a previously registered validator from the object. The specified
     * validator is removed from the object and its <code>validate</code> method
     * is no longer called in {@link #isValid()}.
     * </p>
     *
     * @param validator
     *            the validator to remove
     */
    void removeValidator(Validator validator);

    /**
     * Removes all validators from this object, as if
     * {@link #removeValidator(Validator) removeValidator} was called for each
     * registered validator.
     */
    void removeAllValidators();

    /**
     * <p>
     * Returns a collection of all validators currently registered for the
     * object. The collection may be immutable. Calling
     * <code>removeValidator</code> for this Validatable while iterating over
     * the collection may be unsafe (e.g. may throw
     * <code>ConcurrentModificationException</code>.)
     * </p>
     *
     * @return A collection of validators
     */
    public Collection<Validator> getValidators();

    /**
     * <p>
     * Tests the current value of the object against all registered validators.
     * The registered validators are iterated and for each the
     * {@link Validator#validate(Object)} method is called. If any validator
     * throws the {@link Validator.InvalidValueException} this method returns
     * <code>false</code>.
     * </p>
     *
     * @return <code>true</code> if the registered validators concur that the
     *         value is valid, <code>false</code> otherwise
     */
    public boolean isValid();

    /**
     * <p>
     * Checks the validity of the validatable. If the validatable is valid this
     * method should do nothing, and if it's not valid, it should throw
     * <code>Validator.InvalidValueException</code>
     * </p>
     *
     * @throws Validator.InvalidValueException
     *             if the value is not valid
     */
    public void validate() throws Validator.InvalidValueException;

    /**
     * <p>
     * Checks the validabtable object accept invalid values.The default value is
     * <code>true</code>.
     * </p>
     *
     */
    public boolean isInvalidAllowed();

    /**
     * <p>
     * Should the validabtable object accept invalid values. Supporting this
     * configuration possibility is optional. By default invalid values are
     * allowed.
     * </p>
     *
     * @param invalidValueAllowed
     *
     * @throws UnsupportedOperationException
     *             if the setInvalidAllowed is not supported.
     */
    public void setInvalidAllowed(boolean invalidValueAllowed)
            throws UnsupportedOperationException;

}
