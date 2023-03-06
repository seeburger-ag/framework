/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui;

import com.google.gwt.user.client.ui.UIObject;
import com.vaadin.client.ApplicationConnection;

/**
 * An abstract representation of an icon.
 *
 * @since 7.2
 * @author Vaadin Ltd
 */
public abstract class Icon extends UIObject {

    public static final String CLASSNAME = "v-icon";

    /**
     * Sets the URI for the icon. The URI should be run trough
     * {@link ApplicationConnection#translateVaadinUri(String)} before setting.
     * <p>
     * This might be a URL referencing a image (e.g {@link ImageIcon}) or a
     * custom URI (e.g {@link FontIcon}).
     * </p>
     *
     * @param uri
     *            the URI for this icon
     */
    public abstract void setUri(String uri);

    /**
     * Gets the current URI for this icon.
     *
     * @return URI in use
     */
    public abstract String getUri();

    /**
     * Sets the alternate text for the icon.
     *
     * @param alternateText
     *            with the alternate text.
     */
    public abstract void setAlternateText(String alternateText);

}
