/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.data.bean;

public enum TestEnum {
    ONE("1"), TWO("2");

    private String id;

    private TestEnum(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }
}
