/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.util;

import org.junit.Assert;
import org.junit.Test;

public class EncodeUtilTest {
    @Test
    public void rfc5987Encode() {
        Assert.assertEquals("A", EncodeUtil.rfc5987Encode("A"));
        Assert.assertEquals("%20", EncodeUtil.rfc5987Encode(" "));
        Assert.assertEquals("%c3%a5", EncodeUtil.rfc5987Encode("å"));
        Assert.assertEquals("%e6%97%a5", EncodeUtil.rfc5987Encode("日"));

        Assert.assertEquals("A" + "%20" + "%c3%a5" + "%e6%97%a5",
                EncodeUtil.rfc5987Encode("A å日"));
    }
}
