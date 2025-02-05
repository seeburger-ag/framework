/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.richtextarea;

import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.user.client.Event;
import com.vaadin.client.ApplicationConnection;
import com.vaadin.client.Paintable;
import com.vaadin.client.UIDL;
import com.vaadin.client.ui.AbstractFieldConnector;
import com.vaadin.client.ui.ShortcutActionHandler.BeforeShortcutActionListener;
import com.vaadin.client.ui.SimpleManagedLayout;
import com.vaadin.client.ui.VRichTextArea;
import com.vaadin.shared.ui.Connect;
import com.vaadin.shared.ui.Connect.LoadStyle;
import com.vaadin.shared.ui.textarea.RichTextAreaState;
import com.vaadin.shared.util.SharedUtil;
import com.vaadin.ui.RichTextArea;

@Connect(value = RichTextArea.class, loadStyle = LoadStyle.LAZY)
public class RichTextAreaConnector extends AbstractFieldConnector implements
        Paintable, BeforeShortcutActionListener, SimpleManagedLayout {

    /*
     * Last value received from the server
     */
    private String cachedValue = "";

    @Override
    protected void init() {
        getWidget().addBlurHandler(new BlurHandler() {

            @Override
            public void onBlur(BlurEvent event) {
                flush();
            }
        });
        getLayoutManager().registerDependency(this,
                getWidget().formatter.getElement());
    }

    @Override
    public void onUnregister() {
        super.onUnregister();
        getLayoutManager().unregisterDependency(this,
                getWidget().formatter.getElement());
    }

    @Override
    public void updateFromUIDL(final UIDL uidl, ApplicationConnection client) {
        getWidget().client = client;
        getWidget().id = uidl.getId();

        if (uidl.hasVariable("text")) {
            String newValue = uidl.getStringVariable("text");
            if (!SharedUtil.equals(newValue, cachedValue)) {
                getWidget().setValue(newValue);
                cachedValue = newValue;
            }
        }

        if (!isRealUpdate(uidl)) {
            return;
        }

        getWidget().setEnabled(isEnabled());
        getWidget().setReadOnly(isReadOnly());
        getWidget().immediate = getState().immediate;
        int newMaxLength = uidl.hasAttribute("maxLength")
                ? uidl.getIntAttribute("maxLength") : -1;
        if (newMaxLength >= 0) {
            if (getWidget().maxLength == -1) {
                getWidget().keyPressHandler = getWidget().rta
                        .addKeyPressHandler(getWidget());
            }
            getWidget().maxLength = newMaxLength;
        } else if (getWidget().maxLength != -1) {
            getWidget().getElement().setAttribute("maxlength", "");
            getWidget().maxLength = -1;
            getWidget().keyPressHandler.removeHandler();
        }

        if (uidl.hasAttribute("selectAll")) {
            getWidget().selectAll();
        }

    }

    @Override
    public void onBeforeShortcutAction(Event e) {
        flush();
    }

    @Override
    public VRichTextArea getWidget() {
        return (VRichTextArea) super.getWidget();
    }

    @Override
    public void flush() {
        if (getConnection() != null && getConnectorId() != null) {
            final String html = getWidget().getSanitizedValue();
            if (!html.equals(cachedValue)) {
                cachedValue = html;
                getConnection().updateVariable(getConnectorId(), "text", html,
                        getState().immediate);
            }
        }
    }

    @Override
    public void layout() {
        if (!isUndefinedHeight()) {
            int rootElementInnerHeight = getLayoutManager()
                    .getInnerHeight(getWidget().getElement());
            int formatterHeight = getLayoutManager()
                    .getOuterHeight(getWidget().formatter.getElement());
            int editorHeight = rootElementInnerHeight - formatterHeight;
            if (editorHeight < 0) {
                editorHeight = 0;
            }
            getWidget().rta.setHeight(editorHeight + "px");
        }
    }

    @Override
    public RichTextAreaState getState() {
        return (RichTextAreaState) super.getState();
    }
}
