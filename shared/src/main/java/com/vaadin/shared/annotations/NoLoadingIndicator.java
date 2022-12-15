/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.shared.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Annotation used to mark server RPC methods for which it isn't necessary to
 * show the loading indicator. The framework will show a loading indicator when
 * sending requests for RPC methods that are not marked with this annotation.
 * The loading indicator is hidden once a response is received.
 *
 * @since 7.4
 * @author Vaadin Ltd
 */
@Target(ElementType.METHOD)
@Documented
public @interface NoLoadingIndicator {
    // Just an empty marker annotation
}
