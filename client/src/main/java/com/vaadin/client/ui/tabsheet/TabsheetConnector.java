/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.tabsheet;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Overflow;
import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ConnectorHierarchyChangeEvent;
import com.vaadin.client.TooltipInfo;
import com.vaadin.client.WidgetUtil;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.SimpleManagedLayout;
import com.vaadin.client.ui.VTabsheet;
import com.vaadin.client.ui.layout.MayScrollChildren;
import com.vaadin.shared.ui.Connect;
import com.vaadin.shared.ui.tabsheet.TabsheetClientRpc;
import com.vaadin.ui.TabSheet;

@Connect(TabSheet.class)
public class TabsheetConnector extends TabsheetBaseConnector
        implements SimpleManagedLayout, MayScrollChildren {

    public TabsheetConnector() {
        registerRpc(TabsheetClientRpc.class, new TabsheetClientRpc() {
            @Override
            public void revertToSharedStateSelection() {
                for (int i = 0; i < getState().tabs.size(); ++i) {
                    final String key = getState().tabs.get(i).key;
                    final boolean selected = key.equals(getState().selected);
                    if (selected) {
                        getWidget().waitingForResponse = false;
                        getWidget().setActiveTabIndex(i);
                        getWidget().selectTab(i);
                        break;
                    }
                }
                renderContent();
            }
        });
    }

    @Override
    protected void init() {
        super.init();
        getWidget().setConnector(this);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.vaadin.client.ui.AbstractComponentConnector#onStateChanged(com.vaadin
     * .client.communication.StateChangeEvent)
     */
    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);

        getWidget().handleStyleNames(getState());

        if (getState().tabsVisible) {
            getWidget().showTabs();
        } else {
            getWidget().hideTabs();
        }

        // tabs; push or not
        if (!isUndefinedWidth()) {
            getWidget().tabs.getStyle().setOverflow(Overflow.HIDDEN);
        } else {
            getWidget().showAllTabs();
            getWidget().tabs.getStyle().clearWidth();
            getWidget().tabs.getStyle().setOverflow(Overflow.VISIBLE);
            getWidget().updateDynamicWidth();
        }

        if (!isUndefinedHeight()) {
            // Must update height after the styles have been set
            getWidget().updateContentNodeHeight();
            getWidget().updateOpenTabSize();
        }

        getWidget().iLayout();
    }

    @Override
    public VTabsheet getWidget() {
        return (VTabsheet) super.getWidget();
    }

    @Override
    public void updateCaption(ComponentConnector component) {
        /* Tabsheet does not render its children's captions */
    }

    @Override
    public void layout() {
        VTabsheet tabsheet = getWidget();

        tabsheet.updateContentNodeHeight();

        if (isUndefinedWidth()) {
            tabsheet.contentNode.getStyle().setProperty("width", "");
        } else {
            int contentWidth = tabsheet.getOffsetWidth()
                    - tabsheet.getContentAreaBorderWidth();
            if (contentWidth < 0) {
                contentWidth = 0;
            }
            tabsheet.contentNode.getStyle().setProperty("width",
                    contentWidth + "px");
        }

        tabsheet.updateOpenTabSize();
        if (isUndefinedWidth()) {
            tabsheet.updateDynamicWidth();
        }

        tabsheet.iLayout();

    }

    @Override
    public TooltipInfo getTooltipInfo(Element element) {

        TooltipInfo info = null;

        // Find a tooltip for the tab, if the element is a tab
        if (element != getWidget().getElement()) {
            Object node = WidgetUtil.findWidget(element,
                    VTabsheet.TabCaption.class);

            if (node != null) {
                VTabsheet.TabCaption caption = (VTabsheet.TabCaption) node;
                info = caption.getTooltipInfo();
            }
        }

        // If not tab tooltip was found, use the default
        if (info == null) {
            info = super.getTooltipInfo(element);
        }

        return info;
    }

    @Override
    public boolean hasTooltip() {
        /*
         * Tab tooltips are not processed until updateFromUIDL, so we can't be
         * sure that there are no tooltips during onStateChange when this method
         * is used.
         */
        return true;
    }

    @Override
    public void onConnectorHierarchyChange(
            ConnectorHierarchyChangeEvent connector) {
        renderContent();
    }

    /**
     * (Re-)render the content of the active tab.
     */
    protected void renderContent() {
        ComponentConnector contentConnector = null;
        if (!getChildComponents().isEmpty()) {
            contentConnector = getChildComponents().get(0);
        }

        if (null != contentConnector) {
            getWidget().renderContent(contentConnector.getWidget());
        } else {
            getWidget().renderContent(null);
        }
    }

}
