/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.client.componentlocator.LocatorUtil;

/*
 * Test LocatorUtil.isUIElement() & isNotificaitonElement methods
 */
public class LocatorUtilTest {

    @Test
    public void testIsUI1() {
        boolean isUI = LocatorUtil.isUIElement("com.vaadin.ui.UI");
        Assert.assertTrue(isUI);
    }

    @Test
    public void testIsUI2() {
        boolean isUI = LocatorUtil.isUIElement("/com.vaadin.ui.UI");
        Assert.assertTrue(isUI);
    }

    @Test
    public void testIsUI3() {
        boolean isUI = LocatorUtil
                .isUIElement("//com.vaadin.ui.UI[RandomString");
        Assert.assertTrue(isUI);
    }

    @Test
    public void testIsUI4() {
        boolean isUI = LocatorUtil.isUIElement("//com.vaadin.ui.UI[0]");
        Assert.assertTrue(isUI);
    }

    @Test
    public void testIsNotification1() {
        boolean isUI = LocatorUtil
                .isNotificationElement("com.vaadin.ui.VNotification");
        Assert.assertTrue(isUI);
    }

    @Test
    public void testIsNotification2() {
        boolean isUI = LocatorUtil
                .isNotificationElement("com.vaadin.ui.Notification");
        Assert.assertTrue(isUI);
    }

    @Test
    public void testIsNotification3() {
        boolean isUI = LocatorUtil
                .isNotificationElement("/com.vaadin.ui.VNotification[");
        Assert.assertTrue(isUI);
    }

    @Test
    public void testIsNotification4() {
        boolean isUI = LocatorUtil
                .isNotificationElement("//com.vaadin.ui.VNotification[0]");
        Assert.assertTrue(isUI);
    }
}
