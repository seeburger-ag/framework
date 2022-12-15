/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.integration;

import com.vaadin.annotations.Push;
import com.vaadin.shared.ui.ui.Transport;

/**
 * Server test which uses long polling
 *
 * @since 7.1
 * @author Vaadin Ltd
 */
@Push(transport = Transport.LONG_POLLING)
public class ServletIntegrationLongPollingUI extends ServletIntegrationUI {

}
