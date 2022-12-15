/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.widgetset.client;

/**
 * Dummy state bean used just to check that nothing breaks when generating code
 * to serialize beans with properties in abstract superclasses
 */
public class BeanWithAbstractSuperclass extends AbstractSuperclassForBean {
    public String propertyInsubclass;
}
