/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.client.ui;

import com.google.gwt.core.client.GWT;

public class UnknownComponentConnector extends AbstractComponentConnector {

    @Override
    public boolean delegateCaptionHandling() {
        return false;
    }

    @Override
    public VUnknownComponent getWidget() {
        return (VUnknownComponent) super.getWidget();
    }

    public void setServerSideClassName(String serverClassName) {
        getWidget().setCaption(createMessage(serverClassName));
    }

    public static String createMessage(String serverClassName) {
        return "Widgetset '" + GWT.getModuleName()
                + "' does not contain an implementation for " + serverClassName
                + ". Check the connector's @Connect mapping, the widgetset's "
                + "GWT module description file and re-compile your"
                + " widgetset. In case you have downloaded a vaadin"
                + " add-on package, you might want to refer to "
                + "<a href='http://vaadin.com/using-addons'>add-on "
                + "instructions</a>.";
    }
}
