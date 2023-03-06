/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.server.component.tree;

import org.junit.Test;

import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.tests.server.component.AbstractListenerMethodsTestBase;
import com.vaadin.ui.Tree;
import com.vaadin.ui.Tree.CollapseEvent;
import com.vaadin.ui.Tree.CollapseListener;
import com.vaadin.ui.Tree.ExpandEvent;
import com.vaadin.ui.Tree.ExpandListener;

public class TreeListenersTest extends AbstractListenerMethodsTestBase {

    @Test
    public void testExpandListenerAddGetRemove() throws Exception {
        testListenerAddGetRemove(Tree.class, ExpandEvent.class,
                ExpandListener.class);
    }

    @Test
    public void testItemClickListenerAddGetRemove() throws Exception {
        testListenerAddGetRemove(Tree.class, ItemClickEvent.class,
                ItemClickListener.class);
    }

    @Test
    public void testCollapseListenerAddGetRemove() throws Exception {
        testListenerAddGetRemove(Tree.class, CollapseEvent.class,
                CollapseListener.class);
    }
}
