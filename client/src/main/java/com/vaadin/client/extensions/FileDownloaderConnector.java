/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.client.extensions;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.IFrameElement;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.dom.client.Style.Visibility;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.BrowserInfo;
import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ServerConnector;
import com.vaadin.server.FileDownloader;
import com.vaadin.shared.VBrowserDetails;
import com.vaadin.shared.ui.Connect;

@Connect(FileDownloader.class)
public class FileDownloaderConnector extends AbstractExtensionConnector
        implements ClickHandler {

    private IFrameElement iframe;

    @Override
    protected void extend(ServerConnector target) {
        final Widget downloadWidget = ((ComponentConnector) target).getWidget();

        downloadWidget.addDomHandler(this, ClickEvent.getType());
    }

    @Override
    public void onClick(ClickEvent event) {
        final String url = getResourceUrl("dl");
        if (url != null && !url.isEmpty()) {
            BrowserInfo browser = BrowserInfo.get();
            if (browser.isIOS()) {
                Window.open(url, "_blank", "");
            } else {
                if (iframe != null) {
                    // make sure it is not on dom tree already, might start
                    // multiple downloads at once
                    iframe.removeFromParent();
                }
                iframe = Document.get().createIFrameElement();

                Style style = iframe.getStyle();
                style.setVisibility(Visibility.HIDDEN);
                style.setHeight(0, Unit.PX);
                style.setWidth(0, Unit.PX);

                iframe.setFrameBorder(0);
                iframe.setTabIndex(-1);
                iframe.setSrc(url);
                RootPanel.getBodyElement().appendChild(iframe);
            }
        }
    }

    @Override
    public void setParent(ServerConnector parent) {
        super.setParent(parent);
        if (parent == null && iframe != null) {
            iframe.removeFromParent();
        }
    }

}
