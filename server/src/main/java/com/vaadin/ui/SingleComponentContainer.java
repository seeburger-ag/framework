/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.ui;

import com.vaadin.ui.HasComponents.ComponentAttachDetachNotifier;

/**
 * Interface for component containers that have one child component and do not
 * support adding or removing components.
 *
 * For component containers that support multiple children, see
 * {@link ComponentContainer} instead.
 *
 * @since 7.0
 */
public interface SingleComponentContainer
        extends HasComponents, ComponentAttachDetachNotifier {

    /**
     * Gets the number of children this {@link SingleComponentContainer} has.
     * This must be symmetric with what {@link #iterator()} returns and thus
     * typically return 1 if the content is set, 0 otherwise.
     *
     * @return The number of child components this container has.
     */
    public int getComponentCount();

    /**
     * Gets the content of this container. The content is a component that
     * serves as the outermost item of the visual contents.
     *
     * @return a component to use as content
     *
     * @see #setContent(Component)
     */
    public Component getContent();

    /**
     * Sets the content of this container. The content is a component that
     * serves as the outermost item of the visual contents.
     *
     * The content should always be set, either as a constructor parameter or by
     * calling this method.
     *
     * @return a component (typically a layout) to use as content
     */
    public void setContent(Component content);

}
