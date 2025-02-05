/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.design.designroot;

import org.junit.Assert;
import org.junit.Test;

public class DesignRootTest {
    @Test
    public void designAnnotationWithoutFilename() {
        DesignWithEmptyAnnotation d = new DesignWithEmptyAnnotation();
        Assert.assertNotNull(d.ok);
        Assert.assertNotNull(d.CaNCEL);
        Assert.assertEquals("original", d.preInitializedField.getValue());
    }

    @Test
    public void designAnnotationWithFilename() {
        DesignWithAnnotation d = new DesignWithAnnotation();
        Assert.assertNotNull(d.ok);
        Assert.assertNotNull(d.cancel);
        Assert.assertEquals("original", d.preInitializedField.getValue());
    }

    @Test
    public void extendedDesignAnnotationWithoutFilename() {
        DesignWithEmptyAnnotation d = new ExtendedDesignWithEmptyAnnotation();
        Assert.assertNotNull(d.ok);
        Assert.assertNotNull(d.CaNCEL);
        Assert.assertEquals("original", d.preInitializedField.getValue());
    }

    @Test
    public void extendedDesignAnnotationWithFilename() {
        DesignWithAnnotation d = new ExtendedDesignWithAnnotation();
        Assert.assertNotNull(d.ok);
        Assert.assertNotNull(d.cancel);
        Assert.assertEquals("original", d.preInitializedField.getValue());
    }

}
