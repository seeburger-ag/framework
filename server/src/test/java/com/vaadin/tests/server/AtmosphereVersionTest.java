/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.server;

import static org.junit.Assert.assertEquals;

import org.atmosphere.util.Version;
import org.junit.Test;

import com.vaadin.server.Constants;

public class AtmosphereVersionTest {

    /**
     * Test that the atmosphere version constant matches the version on our
     * classpath
     */
    @Test
    public void testAtmosphereVersion() {
        assertEquals(Constants.REQUIRED_ATMOSPHERE_RUNTIME_VERSION,
                Version.getRawVersion());
    }
}
