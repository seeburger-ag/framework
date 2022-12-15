/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.server.component.listselect;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.shared.ui.select.AbstractSelectState;
import com.vaadin.ui.ListSelect;

/**
 * Tests for ListSelect State.
 *
 */
public class ListSelectStateTest {

    @Test
    public void getState_listSelectHasCustomState() {
        TestListSelect select = new TestListSelect();
        AbstractSelectState state = select.getState();
        Assert.assertEquals("Unexpected state class", AbstractSelectState.class,
                state.getClass());
    }

    private static class TestListSelect extends ListSelect {
        @Override
        public AbstractSelectState getState() {
            return super.getState();
        }
    }

}
