/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.data.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test for MethodProperty: don't allocate unnecessary Object arrays.
 *
 * @since 7.2
 * @author Vaadin Ltd
 */
public class MethodPropertyMemoryConsumptionTest {

    @Test
    public void testSetArguments()
            throws NoSuchFieldException, SecurityException,
            IllegalArgumentException, IllegalAccessException {
        TestBean bean = new TestBean();
        TestMethodProperty<String> property = new TestMethodProperty<String>(
                bean, "name");
        Object[] getArgs = property.getGetArgs();
        Object[] setArgs = property.getSetArgs();

        Field getArgsField = TestMethodProperty.class
                .getDeclaredField("getArgs");
        getArgsField.setAccessible(true);

        Field setArgsField = TestMethodProperty.class
                .getDeclaredField("setArgs");
        setArgsField.setAccessible(true);

        Assert.assertSame(
                "setArguments method sets non-default instance"
                        + " of empty Object array for getArgs",
                getArgsField.get(property), getArgs);

        Assert.assertSame(
                "setArguments method sets non-default instance"
                        + " of empty Object array for setArgs",
                setArgsField.get(property), setArgs);
    }

    @Test
    public void testDefaultCtor() {
        TestBean bean = new TestBean();
        TestMethodProperty<String> property = new TestMethodProperty<String>(
                bean, "name");

        Object[] getArgs = property.getGetArgs();
        Object[] setArgs = property.getSetArgs();

        TestBean otherBean = new TestBean();
        TestMethodProperty<String> otherProperty = new TestMethodProperty<String>(
                otherBean, "name");
        Assert.assertSame(
                "setArguments method uses different instance"
                        + " of empty Object array for getArgs",
                getArgs, otherProperty.getGetArgs());
        Assert.assertSame(
                "setArguments method uses different instance"
                        + " of empty Object array for setArgs",
                setArgs, otherProperty.getSetArgs());
    }

    @Test
    public void testDefaultArgsSerialization()
            throws IOException, ClassNotFoundException {
        TestBean bean = new TestBean();
        TestMethodProperty<String> property = new TestMethodProperty<String>(
                bean, "name");

        ByteArrayOutputStream sourceOutStream = new ByteArrayOutputStream();
        ObjectOutputStream outStream = new ObjectOutputStream(sourceOutStream);
        outStream.writeObject(property);

        ObjectInputStream inputStream = new ObjectInputStream(
                new ByteArrayInputStream(sourceOutStream.toByteArray()));
        Object red = inputStream.readObject();
        TestMethodProperty<?> deserialized = (TestMethodProperty<?>) red;

        Assert.assertNotNull("Deseriliation doesn't call setArguments method",
                deserialized.getGetArgs());
        Assert.assertNotNull("Deseriliation doesn't call setArguments method",
                deserialized.getSetArgs());

    }

    public static class TestMethodProperty<T> extends MethodProperty<T> {

        public TestMethodProperty(Object instance, String beanPropertyName) {
            super(instance, beanPropertyName);
        }

        @Override
        public void setArguments(Object[] getArgs, Object[] setArgs,
                int setArgumentIndex) {
            super.setArguments(getArgs, setArgs, setArgumentIndex);
            this.getArgs = getArgs;
            this.setArgs = setArgs;
        }

        Object[] getGetArgs() {
            return getArgs;
        }

        Object[] getSetArgs() {
            return setArgs;
        }

        private transient Object[] getArgs;
        private transient Object[] setArgs;
    }

    public static class TestBean implements Serializable {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
}
