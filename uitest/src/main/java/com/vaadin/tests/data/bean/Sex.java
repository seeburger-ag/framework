/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.data.bean;

public enum Sex {
    MALE("Male"), FEMALE("Female"), UNKNOWN("Unknown");

    private String stringRepresentation;

    private Sex(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }

    public String getStringRepresentation() {
        return stringRepresentation;
    }

    @Override
    public String toString() {
        return getStringRepresentation();
    }
}
