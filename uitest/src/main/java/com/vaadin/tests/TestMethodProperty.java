/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests;

import com.vaadin.data.util.MethodProperty;

public class TestMethodProperty {

    /**
     * @param args
     */
    public static void main(String[] args) {

        MyTest myTest = new MyTest();

        MethodProperty<Integer> methodProperty2 = new MethodProperty<Integer>(
                Integer.TYPE, myTest, "getInt", "setInt", new Object[0],
                new Object[] { null }, 0);

        methodProperty2.setValue(3);

        System.out.println("Succeeded");

    }

    public static class MyTest {

        int integer;

        public void setInteger(Integer integer) {
            System.out.println("setInteger");
            this.integer = integer;
        }

        public Integer getInteger() {
            System.out.println("getInteger");
            return Integer.valueOf(integer);
        }

        public void setInt(int i) {
            System.out.println("setInt");
            integer = i;
        }

        public int getInt() {
            System.out.println("getInt");
            return integer;
        }
    }
}
