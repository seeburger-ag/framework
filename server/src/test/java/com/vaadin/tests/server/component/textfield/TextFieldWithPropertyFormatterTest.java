/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.server.component.textfield;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.data.util.PropertyFormatter;
import com.vaadin.ui.TextField;

public class TextFieldWithPropertyFormatterTest {

    private static final String INPUT_VALUE = "foo";
    private static final String PARSED_VALUE = "BAR";
    private static final String FORMATTED_VALUE = "FOOBAR";
    private static final String ORIGINAL_VALUE = "Original";
    private TextField field;
    private PropertyFormatter<String> formatter;
    private ObjectProperty<String> property;
    private ValueChangeListener listener;
    private int listenerCalled;
    private int repainted;

    @Before
    public void setUp() {

        field = new TextField() {
            @Override
            public void markAsDirty() {
                repainted++;
                super.markAsDirty();
            }
        };

        formatter = new PropertyFormatter<String>() {

            @Override
            public String parse(String formattedValue) throws Exception {
                assertEquals(INPUT_VALUE, formattedValue);
                return PARSED_VALUE;
            }

            @Override
            public String format(String value) {
                return FORMATTED_VALUE;
            }
        };

        property = new ObjectProperty<String>(ORIGINAL_VALUE);

        formatter.setPropertyDataSource(property);
        field.setPropertyDataSource(formatter);

        listener = new Property.ValueChangeListener() {

            @Override
            public void valueChange(ValueChangeEvent event) {
                listenerCalled++;
                assertEquals(1, listenerCalled);
                assertEquals(FORMATTED_VALUE, event.getProperty().getValue());
            }
        };

        field.addListener(listener);
        listenerCalled = 0;
        repainted = 0;
    }

    @Test
    public void testWithServerApi() {
        checkInitialState();

        field.setValue(INPUT_VALUE);

        checkEndState();

    }

    private void checkEndState() {
        assertEquals(1, listenerCalled);
        assertTrue(repainted >= 1);
        assertEquals(FORMATTED_VALUE, field.getValue());
        assertEquals(FORMATTED_VALUE, formatter.getValue());
        assertEquals(PARSED_VALUE, property.getValue());
    }

    private void checkInitialState() {
        assertEquals(ORIGINAL_VALUE, property.getValue());
        assertEquals(FORMATTED_VALUE, formatter.getValue());
        assertEquals(FORMATTED_VALUE, field.getValue());
    }

    @Test
    public void testWithSimulatedClientSideChange() {
        checkInitialState();

        field.changeVariables(null,
                Collections.singletonMap("text", (Object) INPUT_VALUE));

        checkEndState();

    }

}
