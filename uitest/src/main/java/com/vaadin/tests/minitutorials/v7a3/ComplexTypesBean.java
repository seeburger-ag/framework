/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.minitutorials.v7a3;

public class ComplexTypesBean {
    private int integer;
    private ComplexTypesBean bean;

    public int getInteger() {
        return integer;
    }

    public void setInteger(int integer) {
        this.integer = integer;
    }

    public ComplexTypesBean getBean() {
        return bean;
    }

    public void setBean(ComplexTypesBean bean) {
        this.bean = bean;
    }

}
