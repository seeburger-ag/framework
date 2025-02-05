/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.server;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Assert;
import org.junit.Test;

/**
 * We test that AbstractClientConnector has a suitable isThis method which is
 * needed to correctly perform an equals check between a proxy and it's
 * underlying instance.
 *
 * @author Vaadin Ltd
 */
public class AbstractClientConnectorProxyHandlingTest {

    @Test
    public void abstractClientConnectorTest() {
        try {
            Method method = AbstractClientConnector.class
                    .getDeclaredMethod("isThis", Object.class);
            int modifiers = method.getModifiers();
            if (Modifier.isFinal(modifiers) || !Modifier.isProtected(modifiers)
                    || Modifier.isStatic(modifiers)) {
                Assert.fail(
                        "isThis has invalid modifiers, CDI proxies will not work.");
            }
        } catch (SecurityException e) {
            // Ignore, no can do
        } catch (NoSuchMethodException e) {
            Assert.fail("isThis is missing, CDI proxies will not work.");
        }
    }

}
