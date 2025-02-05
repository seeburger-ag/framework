/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.util;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class ReflectToolsGetPrimitiveFieldValueTest {
    @Test
    public void getFieldValueViaGetter() {
        class MyClass {
            public int field = 1;
        }

        MyClass myInstance = new MyClass();

        java.lang.reflect.Field memberField;
        Object fieldValue = new Boolean(false);
        try {
            memberField = myInstance.getClass().getField("field");
            fieldValue = ReflectTools.getJavaFieldValue(myInstance,
                    memberField);
        } catch (Exception e) {
        }
        assertFalse(fieldValue instanceof Boolean);
    }
}
