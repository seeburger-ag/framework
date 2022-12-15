/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.client.ui;

import com.google.gwt.user.client.Command;

/**
 *
 */
public abstract class Action implements Command {

    protected ActionOwner owner;

    protected String iconUrl = null;

    protected String caption = "";

    public Action(ActionOwner owner) {
        this.owner = owner;
    }

    /**
     * Executed when action fired
     */
    @Override
    public abstract void execute();

    public String getHTML() {
        final StringBuffer sb = new StringBuffer();
        sb.append("<div>");
        // Could store the icon in a field instead, but it doesn't really matter
        // right now because Actions are recreated every time they are needed
        Icon icon = owner.getClient().getIcon(getIconUrl());
        if (icon != null) {
            icon.setAlternateText("icon");
            sb.append(icon.getElement().getString());
        }
        sb.append(getCaption());
        sb.append("</div>");
        return sb.toString();
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String url) {
        iconUrl = url;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Action [owner=" + owner + ", iconUrl=" + iconUrl + ", caption="
                + caption + "]";
    }
}
