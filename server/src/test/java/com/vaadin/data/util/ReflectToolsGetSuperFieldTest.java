/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.data.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.ui.TextField;

public class ReflectToolsGetSuperFieldTest {

    @Test
    public void getFieldFromSuperClass() {
        class MyClass {
            @PropertyId("testProperty")
            TextField test = new TextField("This is a test");
        }
        class MySubClass extends MyClass {
            // no fields here
        }

        PropertysetItem item = new PropertysetItem();
        item.addItemProperty("testProperty",
                new ObjectProperty<String>("Value of testProperty"));

        MySubClass form = new MySubClass();

        FieldGroup binder = new FieldGroup(item);
        binder.bindMemberFields(form);

        assertTrue("Value of testProperty".equals(form.test.getValue()));
    }

}
