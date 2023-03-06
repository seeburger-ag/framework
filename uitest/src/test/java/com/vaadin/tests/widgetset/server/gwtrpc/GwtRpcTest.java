/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.widgetset.server.gwtrpc;

import org.junit.Test;
import org.openqa.selenium.By;

import com.vaadin.tests.tb3.MultiBrowserTest;
import com.vaadin.tests.widgetset.client.gwtrpc.GwtRpcButtonConnector;

/**
 * Test the GWT RPC with Vaadin DevMode. See #11709.
 *
 * @author Vaadin Ltd
 */
public class GwtRpcTest extends MultiBrowserTest {

    @Test
    public void testGwtRpc() {
        openTestURL();

        getDriver().findElement(By.id(GwtRpc.BUTTON_ID)).click();

        By label = By.id(GwtRpcButtonConnector.SUCCESS_LABEL_ID);

        waitForElementVisible(label);
        getDriver().findElement(label);
    }

}
