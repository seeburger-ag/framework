/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.debug;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import com.vaadin.tests.tb3.SingleBrowserTest;

public class ProfilerZeroOverheadTest extends SingleBrowserTest {
    @Test
    public void testZeroOverhead() {
        openTestURL();

        /*
         * This will get the compiled JS for the
         * ProfilerCompilationCanary.canaryWithProfiler method. Expected to be
         * something like "function canaryWithProfiler(){\n}" with a PRETTY
         * non-draft widgetset.
         */
        String canaryMethodString = findElement(By.className("gwt-Label"))
                .getText();

        // Only look at the method body to avoid false negatives if e.g.
        // obfuscation changes
        int bodyStart = canaryMethodString.indexOf('{');
        int bodyEnd = canaryMethodString.lastIndexOf('}');

        String methodBody = canaryMethodString.substring(bodyStart + 1,
                bodyEnd);

        // Method body shouldn't contain anything else than whitespace
        if (!methodBody.replaceAll("\\s", "").isEmpty()) {
            Assert.fail("Canary method is not empty: " + canaryMethodString);
        }
    }
}
