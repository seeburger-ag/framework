/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.debug.internal;

import com.google.gwt.user.client.ui.Button;

/**
 * Simple extension of {@link Button} that is preconfigured with for use in
 * {@link VDebugWindow}. Uses icon-font for icons, and allows title to be
 * specified in the constructor.
 *
 * @since 7.1
 * @author Vaadin Ltd
 */
public class DebugButton extends Button {

    protected boolean active = false;

    /**
     * Creates a {@link Button} with the given icon-font icon. The icon id will
     * be used in the <i>data-icon</i> attribute of an <i>&lt;i&gt;</i> -tag.
     *
     * @param icon
     *            Identifier for the desired icon in an icon-font
     */
    public DebugButton(Icon icon) {
        this(icon, null, null);
    }

    /*-
    public DebugButton(String caption) {
        this(null, null, caption);
    }

    public DebugButton(String caption, String title) {
        this(null, title, caption);
    }
    -*/

    /**
     * Creates a {@link Button} with the given icon-font icon and title
     * (tooltip). The icon id will be used in the <i>data-icon</i> attribute of
     * an <i>&lt;i&gt;</i> -tag.
     *
     * @param icon
     *            Identifier for the desired icon in an icon-font
     * @param title
     *            Button title (tooltip)
     *
     */
    public DebugButton(Icon icon, String title) {
        this(icon, title, null);
    }

    /**
     * Creates a {@link Button} with the given icon-font icon, title (tooltip),
     * and caption. The icon id will be used in the <i>data-icon</i> attribute
     * of an <i>&lt;i&gt;</i> -tag.
     *
     * @param icon
     *            Identifier for the desired icon in an icon-font
     * @param title
     *            Title (tooltip)
     * @param caption
     *            Button baption
     */
    public DebugButton(Icon icon, String title, String caption) {
        super((icon != null ? icon : "") + (caption != null ? caption : ""));
        if (title != null) {
            setTitle(title);
        }

        setStylePrimaryName(VDebugWindow.STYLENAME_BUTTON);
    }

    /**
     * Adds or removes a stylename, indicating whether or not the button is in
     * it's active state.
     *
     * @param active
     */
    public void setActive(boolean active) {
        this.active = active;
        setStyleDependentName(VDebugWindow.STYLENAME_ACTIVE, active);
    }

    /**
     * Indicates wheter the Button is currently in its active state or not
     *
     * @return true if the Button is active, false otherwise
     */
    public boolean isActive() {
        return active;
    }

}
