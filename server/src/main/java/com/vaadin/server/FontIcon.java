/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.server;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Label;

/**
 * A font icon is a type of icon that is made by displaying one character from a
 * specially constructed font containing icons ("icon font").
 * <p>
 * {@link FontIcon} is a custom resource type which uses the URI scheme
 * <code>fonticon://&lt;fontfamily&gt;/&lt;codepoint&gt;</code> to reference a
 * specific icon from a specific icon font. <br/>
 * </p>
 *
 * @since 7.2
 * @author Vaadin Ltd
 */
public interface FontIcon extends Resource {
    /**
     * Returns the name (font family) of the font from which this icon comes.
     * The name is used to apply the correct font where the icon is used.
     *
     * @since 7.2
     * @return
     */
    public String getFontFamily();

    /**
     * Returns the unicode codepoint (character location) for this icon within
     * the font given in {@link #getFontFamily()}.
     * <p>
     * For example, 0x0021 would in a regular font be the codepoint for the
     * exclamation-point character.<br/>
     * When constructing icon fonts, it might be a good idea to use the
     * codepoints in the "Private use area", from 0xE000 0xF8FF.
     * </p>
     *
     * @since 7.2
     * @return
     */
    public int getCodepoint();

    /**
     * Returns HTML that can be used to display the icon in places where HTML
     * can be used, such as a {@link Label} with {@link ContentMode#HTML}.
     *
     *
     * @since 7.2
     * @return HTML needed to display icon
     */
    public String getHtml();
}
