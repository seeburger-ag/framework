/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.design;

import java.io.ByteArrayInputStream;

import org.junit.Test;

import com.vaadin.ui.declarative.Design;

/**
 * Parse mixed content with legacy and new prefixes (not a required feature but
 * works).
 */
public class ParseMixedLegacyAndNewPrefixTest {
    @Test
    public void parseMixedContent() {
        Design.read(new ByteArrayInputStream(
                "<v-vertical-layout><vaadin-label /></v-vertical-layout>"
                        .getBytes()));
    }
}
