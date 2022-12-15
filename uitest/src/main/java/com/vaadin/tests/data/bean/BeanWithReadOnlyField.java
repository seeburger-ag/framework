/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.data.bean;

public class BeanWithReadOnlyField {
    private String readOnlyField;
    private String writableField;

    public String getWritableField() {
        return writableField;
    }

    public void setWritableField(String writableField) {
        this.writableField = writableField;
    }

    public String getReadOnlyField() {
        return readOnlyField;
    }
}
