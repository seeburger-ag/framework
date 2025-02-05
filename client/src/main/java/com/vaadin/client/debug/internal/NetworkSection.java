/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.debug.internal;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ApplicationConnection;
import com.vaadin.client.VUIDLBrowser;
import com.vaadin.client.ValueMap;

/**
 * Displays network activity; requests and responses.
 *
 * Currently only displays responses in a simple manner.
 *
 * @since 7.1
 * @author Vaadin Ltd
 */
public class NetworkSection implements Section {

    private final int maxSize = 10;

    private final DebugButton tabButton = new DebugButton(Icon.NETWORK,
            "Communication");

    private final HTML controls = new HTML(tabButton.getTitle());
    private final FlowPanel content = new FlowPanel();

    public NetworkSection() {
        content.setStyleName(VDebugWindow.STYLENAME + "-network");
    }

    @Override
    public DebugButton getTabButton() {
        return tabButton;
    }

    @Override
    public Widget getControls() {
        return controls;
    }

    @Override
    public Widget getContent() {
        return content;
    }

    @Override
    public void show() {
        // TODO Auto-generated method stub

    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub

    }

    @Override
    public void meta(ApplicationConnection ac, ValueMap meta) {
        // NOP
    }

    @Override
    public void uidl(ApplicationConnection ac, ValueMap uidl) {
        int sinceStart = VDebugWindow.getMillisSinceStart();
        int sinceReset = VDebugWindow.getMillisSinceReset();

        VUIDLBrowser vuidlBrowser = new VUIDLBrowser(uidl, ac);
        vuidlBrowser.addStyleName(VDebugWindow.STYLENAME + "-row");
        vuidlBrowser.setText("Response @ " + sinceReset + "ms");
        vuidlBrowser.setTitle(
                VDebugWindow.getTimingTooltip(sinceStart, sinceReset));
        vuidlBrowser.close();

        content.add(vuidlBrowser);

        while (content.getWidgetCount() > maxSize) {
            content.remove(0);
        }
    }

}
