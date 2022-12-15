/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.data.validator;

/**
 * String validator for e-mail addresses. The e-mail address syntax is not
 * complete according to RFC 822 but handles the vast majority of valid e-mail
 * addresses correctly.
 *
 * See {@link AbstractStringValidator} for more information.
 *
 * <p>
 * An empty string or a null is always accepted - use the required flag on
 * fields or a separate validator (or override {@link #isValidValue(String)}) to
 * fail on empty values.
 * </p>
 *
 * @author Vaadin Ltd.
 * @since 5.4
 */
@SuppressWarnings("serial")
public class EmailValidator extends RegexpValidator {

    private static final String PATTERN = "^" + "([a-zA-Z0-9_\\.\\-+])+" // local
            + "@" + "[a-zA-Z0-9-.]+" // domain
            + "\\." + "[a-zA-Z0-9-]{2,}" // tld
            + "$";

     
    /**
     * Creates a validator for checking that a string is a syntactically valid
     * e-mail address.
     *
     * @param errorMessage
     *            the message to display in case the value does not validate.
     */
    public EmailValidator(String errorMessage) {
        super(PATTERN, true, errorMessage);
    }
}
