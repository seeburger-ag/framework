/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.serialization;

import com.vaadin.annotations.Widgetset;
import com.vaadin.server.AbstractExtension;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUIWithLog;
import com.vaadin.tests.widgetset.TestingWidgetSet;
import com.vaadin.tests.widgetset.client.EncoderResultDisplayConnector;
import com.vaadin.tests.widgetset.client.EncoderResultDisplayConnector.ReportRpc;

@Widgetset(TestingWidgetSet.NAME)
public class EncodeResultDisplay extends AbstractTestUIWithLog {

    public static class EncoderResultDisplayExtension
            extends AbstractExtension {
        public EncoderResultDisplayExtension(
                EncoderResultDisplayConnector.ReportRpc rpc) {
            registerRpc(rpc);
        }

        public void extend(EncodeResultDisplay target) {
            super.extend(target);
        }
    }

    @Override
    protected void setup(VaadinRequest request) {
        log.setNumberLogRows(false);
        new EncoderResultDisplayExtension(new ReportRpc() {
            @Override
            public void report(String name, String encodedValue) {
                log(name + ": " + encodedValue);
            }
        }).extend(this);
    }

    @Override
    protected int getLogSize() {
        return 15;
    }
}
