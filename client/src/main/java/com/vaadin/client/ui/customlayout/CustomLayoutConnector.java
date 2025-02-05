/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.customlayout;

import java.util.logging.Logger;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ApplicationConnection;
import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ConnectorHierarchyChangeEvent;
import com.vaadin.client.Paintable;
import com.vaadin.client.UIDL;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractLayoutConnector;
import com.vaadin.client.ui.SimpleManagedLayout;
import com.vaadin.client.ui.VCustomLayout;
import com.vaadin.shared.ui.Connect;
import com.vaadin.shared.ui.customlayout.CustomLayoutState;
import com.vaadin.ui.CustomLayout;

@Connect(CustomLayout.class)
public class CustomLayoutConnector extends AbstractLayoutConnector
        implements SimpleManagedLayout, Paintable {

    private boolean templateUpdated;

    @Override
    public CustomLayoutState getState() {
        return (CustomLayoutState) super.getState();
    }

    @Override
    protected void init() {
        super.init();
        getWidget().client = getConnection();
        getWidget().pid = getConnectorId();

    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);

        // Ensure the template is initialized even if there are no children
        // (#9725)
        updateHtmlTemplate();

        // Evaluate scripts
        VCustomLayout.eval(getWidget().scripts);
        getWidget().scripts = null;

    }

    private void updateHtmlTemplate() {
        if (templateUpdated) {
            // We (currently) only do this once. You can't change the template
            // later on.
            return;
        }
        String templateName = getState().templateName;
        String templateContents = getState().templateContents;

        if (templateName != null) {
            // Get the HTML-template from client. Overrides templateContents
            // (even though both can never be given at the same time)
            templateContents = getConnection()
                    .getResource("layouts/" + templateName + ".html");
        }

        if (templateContents != null) {
            // Template ok -> initialize.
            getWidget().initializeHTML(templateContents,
                    getConnection().getThemeUri());
        } else {
            // Template missing -> show debug notice and render components in
            // order.
            String warning = templateName != null
                    ? "Layout file layouts/" + templateName
                            + ".html is missing."
                    : "Layout file not specified.";
            getWidget().getElement().setInnerHTML("<em>" + warning
                    + " Components will be drawn for debug purposes.</em>");
        }
        templateUpdated = true;
    }

    @Override
    public void onConnectorHierarchyChange(
            ConnectorHierarchyChangeEvent event) {
        // Must call here in addition to onStateChanged because
        // onConnectorHierarchyChange is invoked before onStateChanged
        updateHtmlTemplate();
        // For all contained widgets
        for (ComponentConnector child : getChildComponents()) {
            String location = getState().childLocations.get(child);
            try {
                getWidget().setWidget(child.getWidget(), location);
            } catch (final IllegalArgumentException e) {
                // If no location is found, this component is not visible
                getLogger().warning("Child not rendered as no slot with id '"
                        + location + "' has been defined");
            }
        }
        for (ComponentConnector oldChild : event.getOldChildren()) {
            if (oldChild.getParent() == this) {
                // Connector still a child of this
                continue;
            }
            Widget oldChildWidget = oldChild.getWidget();
            if (oldChildWidget.isAttached()) {
                // slot of this widget is emptied, remove it
                getWidget().remove(oldChildWidget);
            }
        }

    }

    @Override
    public VCustomLayout getWidget() {
        return (VCustomLayout) super.getWidget();
    }

    @Override
    public void updateCaption(ComponentConnector paintable) {
        getWidget().updateCaption(paintable);
    }

    @Override
    public void layout() {
        getWidget().iLayoutJS(DOM.getFirstChild(getWidget().getElement()));
    }

    @Override
    public void updateFromUIDL(UIDL uidl, ApplicationConnection client) {
        // Not interested in anything from the UIDL - just implementing the
        // interface to avoid some warning (#8688)
    }

    private static Logger getLogger() {
        return Logger.getLogger(CustomLayoutConnector.class.getName());
    }
}
