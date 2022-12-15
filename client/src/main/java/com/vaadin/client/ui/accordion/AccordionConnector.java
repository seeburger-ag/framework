/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.accordion;

import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ConnectorHierarchyChangeEvent;
import com.vaadin.client.WidgetUtil;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.SimpleManagedLayout;
import com.vaadin.client.ui.VAccordion;
import com.vaadin.client.ui.VAccordion.StackItem;
import com.vaadin.client.ui.layout.MayScrollChildren;
import com.vaadin.client.ui.tabsheet.TabsheetBaseConnector;
import com.vaadin.shared.ui.Connect;
import com.vaadin.shared.ui.accordion.AccordionState;
import com.vaadin.ui.Accordion;

@Connect(Accordion.class)
public class AccordionConnector extends TabsheetBaseConnector
        implements SimpleManagedLayout, MayScrollChildren {

    @Override
    protected void init() {
        super.init();
        getWidget().setConnector(this);
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);

        /*
         * Render content after all tabs have been created and we know how large
         * the content area is
         */
        if (getWidget().selectedItemIndex >= 0) {
            StackItem selectedItem = getWidget()
                    .getStackItem(getWidget().selectedItemIndex);

            ComponentConnector contentConnector = getChildComponents().get(0);
            if (contentConnector != null) {
                selectedItem.setContent(contentConnector.getWidget());
            }

            getWidget().open(getWidget().selectedItemIndex);

        } else if (getWidget().getOpenStackItem() != null) {
            getWidget().close(getWidget().getOpenStackItem());
        }
        getLayoutManager().setNeedsVerticalLayout(this);
    }

    @Override
    public VAccordion getWidget() {
        return (VAccordion) super.getWidget();
    }

    @Override
    public void updateCaption(ComponentConnector component) {
        /* Accordion does not render its children's captions */
    }

    @Override
    public void layout() {
        StackItem openTab = getWidget().getOpenStackItem();
        if (openTab == null) {
            return;
        }

        // WIDTH
        if (!isUndefinedWidth()) {
            openTab.setWidth("100%");
        } else {
            int maxWidth = 40;
            for (StackItem si : getWidget().getStackItems()) {
                int captionWidth = si.getCaptionWidth();
                if (captionWidth > maxWidth) {
                    maxWidth = captionWidth;
                }
            }
            int widgetWidth = openTab.getWidgetWidth();
            if (widgetWidth > maxWidth) {
                maxWidth = widgetWidth;
            }
            openTab.setWidth(maxWidth);
        }

        // HEIGHT
        if (!isUndefinedHeight()) {
            int usedPixels = 0;
            for (StackItem item : getWidget().getStackItems()) {
                if (item == openTab) {
                    usedPixels += item.getCaptionHeight();
                } else {
                    // This includes the captionNode borders
                    usedPixels += WidgetUtil
                            .getRequiredHeight(item.getElement());
                }
            }
            int rootElementInnerHeight = getLayoutManager()
                    .getInnerHeight(getWidget().getElement());
            int spaceForOpenItem = rootElementInnerHeight - usedPixels;

            if (spaceForOpenItem < 0) {
                spaceForOpenItem = 0;
            }

            openTab.setHeight(spaceForOpenItem);
        } else {
            openTab.setHeightFromWidget();
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.client.ConnectorHierarchyChangeEvent.
     * ConnectorHierarchyChangeHandler
     * #onConnectorHierarchyChange(com.vaadin.client
     * .ConnectorHierarchyChangeEvent)
     */
    @Override
    public void onConnectorHierarchyChange(
            ConnectorHierarchyChangeEvent connectorHierarchyChangeEvent) {
    }

    @Override
    public AccordionState getState() {
        return (AccordionState) super.getState();
    }
}
