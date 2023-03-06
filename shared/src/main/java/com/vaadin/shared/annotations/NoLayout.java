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
 * Annotation used to mark client RPC methods, state fields, or state setter
 * methods that should not trigger an layout phase after changes have been
 * processed. Whenever there's at least one change that is not marked with this
 * annotation, the framework will assume some sizes might have changed an will
 * therefore start a layout phase after applying the changes.
 * <p>
 * This annotation can be used for any RPC method or state property that does
 * not cause the size of the component or its children to change. Please note
 * that almost anything related to CSS (e.g. adding or removing a stylename) has
 * the potential of causing sizes to change with appropriate style definitions
 * in the application theme.
 *
 * @since 7.4
 *
 * @author Vaadin Ltd
 */
@Documented
@Target({ ElementType.METHOD, ElementType.FIELD })
public @interface NoLayout {
    // Just an empty marker annotation
}
