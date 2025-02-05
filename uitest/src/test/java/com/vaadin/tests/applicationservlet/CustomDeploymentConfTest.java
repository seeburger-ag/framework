/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.applicationservlet;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.testbench.elements.LabelElement;
import com.vaadin.testbench.elements.VerticalLayoutElement;
import com.vaadin.tests.tb3.MultiBrowserTest;

public class CustomDeploymentConfTest extends MultiBrowserTest {
    @Test
    public void testCustomDeploymentConf() {
        openTestURL();

        LabelElement cacheTimeLabel = $$(VerticalLayoutElement.class)
                .$$(VerticalLayoutElement.class).$$(LabelElement.class).first();

        LabelElement customParamLabel = $$(VerticalLayoutElement.class)
                .$$(VerticalLayoutElement.class).$$(LabelElement.class).get(1);

        Assert.assertEquals("Resource cache time: 3599",
                cacheTimeLabel.getText());
        Assert.assertEquals("Custom config param: customValue",
                customParamLabel.getText());
    }
}
