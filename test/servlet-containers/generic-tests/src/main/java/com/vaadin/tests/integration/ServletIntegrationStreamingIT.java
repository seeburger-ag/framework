/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.integration;

public class ServletIntegrationStreamingIT
        extends AbstractServletIntegrationTest {
    // Uses the test method declared in the super class

    @Override
    protected String getTestPath() {
        return "/run/ServletIntegrationStreamingUI";
    }
}
