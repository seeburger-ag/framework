/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.shared.ui.loginform;

import com.vaadin.shared.AbstractComponentState;
import com.vaadin.shared.Connector;
import com.vaadin.shared.communication.URLReference;

public class LoginFormState extends AbstractComponentState {
    public Connector userNameFieldConnector;
    public Connector passwordFieldConnector;
    public Connector loginButtonConnector;
    public URLReference loginResource;
}
