/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.util;

import java.io.Serializable;

/**
 * Fallback that is used to revolve current instances when they are not
 * available by regular means.
 * <p>
 * This interface is used internally by the framework and it's not meant for
 * public usage.
 * 
 * @author Vaadin Ltd.
 *
 * @param <T>
 *            the type of the instances returned by this resolver
 * 
 * @see CurrentInstance#get(Class)
 * @see CurrentInstance#defineFallbackResolver(Class,
 *      CurrentInstanceFallbackResolver)
 * 
 * @since 7.7.14
 * 
 */
public interface CurrentInstanceFallbackResolver<T> extends Serializable {

    /**
     * Resolves a current instance for the type {@code T}.
     * 
     * @return the current instance, or <code>null</code> if none can be found
     */
    T resolve();

}
