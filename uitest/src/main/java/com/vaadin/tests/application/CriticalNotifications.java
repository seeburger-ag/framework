/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.application;

import java.io.IOException;

import com.vaadin.server.SystemMessages;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinResponse;
import com.vaadin.server.VaadinService;
import com.vaadin.shared.JsonConstants;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CheckBox;

public class CriticalNotifications extends AbstractTestUI {

    private SystemMessages systemMessages;
    private CheckBox includeDetails;

    @Override
    protected void setup(VaadinRequest request) {
        systemMessages = VaadinService.getCurrent()
                .getSystemMessages(getLocale(), request);

        includeDetails = new CheckBox("Include details");
        addComponent(includeDetails);

        Button sessionExpired = new Button("Session expired");
        addComponent(sessionExpired);
        sessionExpired.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                showCriticalNotification(
                        systemMessages.getSessionExpiredCaption(),
                        systemMessages.getSessionExpiredMessage(),
                        getDetailsMessage(),
                        systemMessages.getSessionExpiredURL());

            }
        });

        Button authenticationError = new Button("Authentication error");
        addComponent(authenticationError);
        authenticationError.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                showCriticalNotification(
                        systemMessages.getAuthenticationErrorCaption(),
                        systemMessages.getAuthenticationErrorMessage(),
                        getDetailsMessage(),
                        systemMessages.getAuthenticationErrorURL());

            }
        });

        Button communicationError = new Button("Communication error");
        addComponent(communicationError);
        communicationError.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                showCriticalNotification(
                        systemMessages.getCommunicationErrorCaption(),
                        systemMessages.getCommunicationErrorMessage(),
                        getDetailsMessage(),
                        systemMessages.getCommunicationErrorURL());

            }
        });

        Button internalError = new Button("Internal error");
        addComponent(internalError);
        internalError.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                showCriticalNotification(
                        systemMessages.getInternalErrorCaption(),
                        systemMessages.getInternalErrorMessage(),
                        getDetailsMessage(),
                        systemMessages.getInternalErrorURL());

            }
        });

        Button cookiesDisabled = new Button("Cookies disabled");
        addComponent(cookiesDisabled);
        cookiesDisabled.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                showCriticalNotification(
                        systemMessages.getCookiesDisabledCaption(),
                        systemMessages.getCookiesDisabledMessage(),
                        getDetailsMessage(),
                        systemMessages.getCookiesDisabledURL());

            }
        });
        Button custom = new Button("Custom");
        addComponent(custom);
        custom.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                showCriticalNotification("Custom caption", "Custom message",
                        "Custom details", "custom url");

            }
        });
    }

    protected String getDetailsMessage() {
        if (includeDetails.getValue()) {
            return "Some details for the error";
        } else {
            return null;
        }
    }

    protected void showCriticalNotification(String caption, String message,
            String details, String url) {
        VaadinService service = VaadinService.getCurrent();
        VaadinResponse response = VaadinService.getCurrentResponse();

        try {
            service.writeStringResponse(response,
                    JsonConstants.JSON_CONTENT_TYPE,
                    VaadinService.createCriticalNotificationJSON(caption,
                            message, details, url));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
