/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.server;

/**
 * <code>UserError</code> is a controlled error occurred in application. User
 * errors are occur in normal usage of the application and guide the user.
 *
 * @author Vaadin Ltd.
 * @since 3.0
 */
@SuppressWarnings("serial")
public class UserError extends AbstractErrorMessage {

    /**
     * @deprecated As of 7.0, use {@link ContentMode#TEXT} instead    
     */
    @Deprecated
    public static final ContentMode CONTENT_TEXT = ContentMode.TEXT;

    /**
     * @deprecated As of 7.0, use {@link ContentMode#PREFORMATTED} instead    
     */
    @Deprecated
    public static final ContentMode CONTENT_PREFORMATTED = ContentMode.PREFORMATTED;

    /**
     * @deprecated As of 7.0, use {@link ContentMode#HTML} instead    
     */
    @Deprecated
    public static final ContentMode CONTENT_XHTML = ContentMode.HTML;

    /**
     * Creates a textual error message of level ERROR.
     *
     * @param textErrorMessage
     *            the text of the error message.
     */
    public UserError(String textErrorMessage) {
        super(textErrorMessage);
    }

    /**
     * Creates an error message with level and content mode.
     *
     * @param message
     *            the error message.
     * @param contentMode
     *            the content Mode.
     * @param errorLevel
     *            the level of error.
     */
    public UserError(String message, ContentMode contentMode,
            ErrorLevel errorLevel) {
        super(message);
        if (contentMode == null) {
            contentMode = ContentMode.TEXT;
        }
        if (errorLevel == null) {
            errorLevel = ErrorLevel.ERROR;
        }
        setMode(contentMode);
        setErrorLevel(errorLevel);
    }

}
