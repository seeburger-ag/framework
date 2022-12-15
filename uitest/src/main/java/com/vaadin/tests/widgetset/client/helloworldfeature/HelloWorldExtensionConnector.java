/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.widgetset.client.helloworldfeature;

import com.google.gwt.user.client.Window;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.Util;
import com.vaadin.client.VConsole;
import com.vaadin.client.extensions.AbstractExtensionConnector;
import com.vaadin.shared.ui.Connect;
import com.vaadin.tests.extensions.HelloWorldExtension;

@Connect(HelloWorldExtension.class)
public class HelloWorldExtensionConnector extends AbstractExtensionConnector {

    @Override
    public HelloWorldState getState() {
        return (HelloWorldState) super.getState();
    }

    @Override
    protected void init() {
        registerRpc(GreetAgainRpc.class, new GreetAgainRpc() {
            @Override
            public void greetAgain() {
                greet();
            }
        });
    }

    @Override
    protected void extend(ServerConnector target) {
        greet();
    }

    private void greet() {
        String msg = getState().getGreeting() + " from "
                + Util.getConnectorString(this) + " attached to "
                + Util.getConnectorString(getParent());
        VConsole.log(msg);

        String response = Window.prompt(msg, "");
        getRpcProxy(HelloWorldRpc.class).onMessageSent(response);
    }
}
