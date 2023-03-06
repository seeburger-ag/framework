/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.data.fieldgroup;

import java.io.Serializable;

import com.vaadin.ui.Field;

/**
 * Factory interface for creating new Field-instances based on the data type
 * that should be edited.
 *
 * @author Vaadin Ltd.
 * @since 7.0
 */
public interface FieldGroupFieldFactory extends Serializable {
    /**
     * Creates a field based on the data type that we want to edit
     *
     * @param dataType
     *            The type that we want to edit using the field
     * @param fieldType
     *            The type of field we want to create. If set to {@link Field}
     *            then any type of field is accepted
     * @return A field that can be assigned to the given fieldType and that is
     *         capable of editing the given type of data
     */
    <T extends Field> T createField(Class<?> dataType, Class<T> fieldType);
}
