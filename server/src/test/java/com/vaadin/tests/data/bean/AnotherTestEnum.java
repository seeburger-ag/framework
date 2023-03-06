/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.data.bean;

public enum AnotherTestEnum {
    ONE("ONE"), TWO("TWO");

    private String id;

    private AnotherTestEnum(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }
}
