/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.communication;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @since 7.7
 * @author Vaadin Ltd
 */
public class ServerMessageHandlerTest {

    @Test
    public void unwrapValidJson() {
        String payload = "{'foo': 'bar'}";
        Assert.assertEquals(payload,
                MessageHandler.stripJSONWrapping("for(;;);[" + payload + "]"));

    }

    @Test
    public void unwrapUnwrappedJson() {
        String payload = "{'foo': 'bar'}";
        Assert.assertNull(MessageHandler.stripJSONWrapping(payload));

    }

    @Test
    public void unwrapNull() {
        Assert.assertNull(MessageHandler.stripJSONWrapping(null));

    }

    @Test
    public void unwrapEmpty() {
        Assert.assertNull(MessageHandler.stripJSONWrapping(""));

    }
}
