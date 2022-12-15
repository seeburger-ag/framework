/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.checkbox;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.MouseEventDetails;
import com.vaadin.shared.ui.checkbox.CheckBoxServerRpc;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Label;

public class CheckBoxRpcCount extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        final Label countLabel = new Label("No RPC calls made yet.");
        countLabel.setId("count-label");
        addComponent(countLabel);

        CheckBox cb = new CheckBox("Click me to start counting...") {
            {
                // Register a new RPC that counts the number of invocations.
                registerRpc(new CheckBoxServerRpc() {
                    private int rpcCount = 0;

                    @Override
                    public void setChecked(boolean checked,
                            MouseEventDetails mouseEventDetails) {
                        rpcCount++;
                        countLabel.setValue(rpcCount + " RPC call(s) made.");
                    }

                });
            }
        };
        cb.addValueChangeListener(new ValueChangeListener() {

            @Override
            public void valueChange(ValueChangeEvent event) {
                // Adding an empty ValueChangeListener just to ensure that
                // immediate mode is set to true
            }
        });
        addComponent(cb);
    }

    @Override
    protected String getTestDescription() {
        return "Test for verifying that no extra RPC calls are made when clicking on CheckBox label.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 8259;
    }

}
