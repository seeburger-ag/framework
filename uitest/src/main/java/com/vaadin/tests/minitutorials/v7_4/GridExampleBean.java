/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.minitutorials.v7_4;

public class GridExampleBean {
    private String name;
    private int count;
    private double amount;

    public GridExampleBean() {

    }

    public GridExampleBean(String name, int count, double amount) {
        this.name = name;
        this.count = count;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public double getAmount() {
        return amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}