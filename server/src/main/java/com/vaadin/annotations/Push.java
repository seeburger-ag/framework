/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.vaadin.shared.communication.PushMode;
import com.vaadin.shared.ui.ui.Transport;
import com.vaadin.ui.UI;

/**
 * Configures server push for a {@link UI}. Adding <code>@Push</code> to a UI
 * class configures the UI for automatic push. If some other push mode is
 * desired, it can be passed as a parameter, e.g.
 * <code>@Push(PushMode.MANUAL)</code>.
 *
 * @see PushMode
 *
 * @author Vaadin Ltd.
 * @since 7.1
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface Push {
    /**
     * Returns the {@link PushMode} to use for the annotated UI. The default
     * push mode when this annotation is present is {@link PushMode#AUTOMATIC}.
     *
     * @return the push mode to use
     */
    public PushMode value() default PushMode.AUTOMATIC;

    /**
     * Returns the transport type used for the push for the annotated UI. The
     * default transport type when this annotation is present is
     * {@link Transport#WEBSOCKET}.
     *
     * @return the transport type to use
     */
    public Transport transport() default Transport.WEBSOCKET;

}
