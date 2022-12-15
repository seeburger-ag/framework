/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.widgetset.client;

import java.io.Serializable;

public class SimpleTestBean implements Serializable {
    private int value;

    public SimpleTestBean() {
        this(0);
    }

    public SimpleTestBean(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SimpleTestBean(" + value + ")";
    }

    @Override
    public int hashCode() {
        // Implement hash code to get consistent HashSet.toString
        return value;
    }
}
