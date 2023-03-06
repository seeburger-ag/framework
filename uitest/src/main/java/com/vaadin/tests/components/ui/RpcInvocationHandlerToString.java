/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.ui;

import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ui.PageClientRpc;
import com.vaadin.tests.components.AbstractTestUIWithLog;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

public class RpcInvocationHandlerToString extends AbstractTestUIWithLog {

    PageClientRpc dummyProxy = getRpcProxy(PageClientRpc.class);

    @Override
    protected void setup(VaadinRequest request) {
        addButton("Exec toString() for an invocation proxy",
                new Button.ClickListener() {

                    @Override
                    public void buttonClick(ClickEvent event) {
                        log("An invoation proxy: " + dummyProxy.toString());
                    }
                });
        addButton("Exec hashCode() for an invocation proxy",
                new Button.ClickListener() {

                    @Override
                    public void buttonClick(ClickEvent event) {
                        log("Invocation proxy.hashCode(): "
                                + dummyProxy.hashCode());
                    }
                });
        addButton("Exec equals(false) for an invocation proxy",
                new Button.ClickListener() {

                    @Override
                    public void buttonClick(ClickEvent event) {
                        log("Invocation proxy.equals(false): "
                                + dummyProxy.equals(false));
                    }
                });
    }

    @Override
    protected String getTestDescription() {
        return "Clicking on the buttons invokes Object methods on a dummy proxy instance. They should only cause log rows to appear and no client rpc to be sent";
    }

    @Override
    protected Integer getTicketNumber() {
        return 9802;
    }

}
