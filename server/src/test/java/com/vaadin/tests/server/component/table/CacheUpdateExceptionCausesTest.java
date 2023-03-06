/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests.server.component.table;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.ui.Table;
import com.vaadin.ui.Table.CacheUpdateException;

public class CacheUpdateExceptionCausesTest {
    @Test
    public void testSingleCauseException() {
        Table table = new Table();
        Throwable[] causes = new Throwable[] {
                new RuntimeException("Broken in one way.") };

        CacheUpdateException exception = new CacheUpdateException(table,
                "Error during Table cache update.", causes);

        Assert.assertSame(causes[0], exception.getCause());
        Assert.assertEquals("Error during Table cache update.",
                exception.getMessage());
    }

    @Test
    public void testMultipleCauseException() {
        Table table = new Table();
        Throwable[] causes = new Throwable[] {
                new RuntimeException("Broken in the first way."),
                new RuntimeException("Broken in the second way.") };

        CacheUpdateException exception = new CacheUpdateException(table,
                "Error during Table cache update.", causes);

        Assert.assertSame(causes[0], exception.getCause());
        Assert.assertEquals(
                "Error during Table cache update. Additional causes not shown.",
                exception.getMessage());
    }
}
