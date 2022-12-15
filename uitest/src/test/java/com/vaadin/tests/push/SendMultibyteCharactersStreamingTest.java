/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.push;

public class SendMultibyteCharactersStreamingTest
        extends SendMultibyteCharactersTest {

    @Override
    protected String getTransport() {
        return "streaming";
    }
}
