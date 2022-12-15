/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.client.ui.upload;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.vaadin.client.ApplicationConnection;
import com.vaadin.client.Paintable;
import com.vaadin.client.UIDL;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.client.ui.VUpload;
import com.vaadin.shared.EventId;
import com.vaadin.shared.ui.Connect;
import com.vaadin.shared.ui.upload.UploadClientRpc;
import com.vaadin.shared.ui.upload.UploadServerRpc;
import com.vaadin.shared.ui.upload.UploadState;
import com.vaadin.ui.Upload;

@Connect(Upload.class)
public class UploadConnector extends AbstractComponentConnector
        implements Paintable {

    public UploadConnector() {
        registerRpc(UploadClientRpc.class, new UploadClientRpc() {
            @Override
            public void submitUpload() {
                getWidget().submit();
            }
        });
    }

    @Override
    protected void init() {
        super.init();

        getWidget().fu.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent event) {
                if (hasEventListener(EventId.CHANGE)) {
                    getRpcProxy(UploadServerRpc.class)
                            .change(getWidget().fu.getFilename());
                }
            }
        });
    }

    @Override
    public void updateFromUIDL(UIDL uidl, ApplicationConnection client) {
        if (!isRealUpdate(uidl)) {
            return;
        }
        if (uidl.hasAttribute("notStarted")) {
            getWidget().t.schedule(400);
            return;
        }
        getWidget().setImmediate(getState().immediate);
        getWidget().client = client;
        getWidget().paintableId = uidl.getId();
        getWidget().nextUploadId = uidl.getIntAttribute("nextid");
        final String action = client
                .translateVaadinUri(uidl.getStringVariable("action"));
        getWidget().element.setAction(action);
        if (uidl.hasAttribute("buttoncaption")) {
            getWidget().submitButton
                    .setText(uidl.getStringAttribute("buttoncaption"));
            getWidget().submitButton.setVisible(true);
        } else {
            getWidget().submitButton.setVisible(false);
        }
        getWidget().fu.setName(getWidget().paintableId + "_file");

        if (!isEnabled() || isReadOnly()) {
            getWidget().disableUpload();
        } else if (!uidl.getBooleanAttribute("state")) {
            // Enable the button only if an upload is not in progress
            getWidget().enableUpload();
            getWidget().ensureTargetFrame();
        }
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);

        getWidget().disableTitle(hasTooltip());
    }

    @Override
    public VUpload getWidget() {
        return (VUpload) super.getWidget();
    }

    @Override
    public UploadState getState() {
        return (UploadState) super.getState();
    }
}
