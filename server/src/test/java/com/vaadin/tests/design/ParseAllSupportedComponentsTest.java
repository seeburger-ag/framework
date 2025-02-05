/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.design;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.FileNotFoundException;

import org.junit.Test;

import com.vaadin.ui.declarative.Design;
import com.vaadin.ui.declarative.DesignContext;

/**
 * Just top level test case that contains all synchronizable components
 *
 * @author Vaadin Ltd
 */
public class ParseAllSupportedComponentsTest {

    @Test
    public void allComponentsAreParsed() throws FileNotFoundException {
        DesignContext ctx = Design.read(
                getClass().getResourceAsStream("all-components.html"), null);

        assertThat(ctx, is(not(nullValue())));
        assertThat(ctx.getRootComponent(), is(not(nullValue())));
    }
}
