/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.server.component.abstractsplitpanel;

import org.junit.Test;

import com.vaadin.server.Sizeable.Unit;
import com.vaadin.tests.design.DeclarativeTestBase;
import com.vaadin.ui.AbstractSplitPanel;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;

/**
 * Tests declarative support for AbstractSplitPanel.
 *
 * @since
 * @author Vaadin Ltd
 */
public class AbstractSplitPanelDeclarativeTest
        extends DeclarativeTestBase<AbstractSplitPanel> {

    @Test
    public void testWithBothChildren() {
        String design = "<vaadin-horizontal-split-panel split-position=20.5% "
                + "min-split-position=20% max-split-position=50px locked "
                + "reversed> <vaadin-table /> <vaadin-vertical-layout />"
                + "</vaadin-horizontal-split-panel>";
        AbstractSplitPanel sp = new HorizontalSplitPanel();
        sp.setSplitPosition(20.5f, Unit.PERCENTAGE, true);
        sp.setMinSplitPosition(20, Unit.PERCENTAGE);
        sp.setMaxSplitPosition(50, Unit.PIXELS);
        sp.setLocked(true);
        sp.addComponent(new Table());
        sp.addComponent(new VerticalLayout());
        testRead(design, sp);
        testWrite(design, sp);
    }

    @Test
    public void testWithFirstChild() {
        String design = "<vaadin-vertical-split-panel><vaadin-table caption=\"First slot\"/>"
                + "</vaadin-vertical-split-panel>";
        AbstractSplitPanel sp = new VerticalSplitPanel();
        Table t = new Table();
        t.setCaption("First slot");
        sp.addComponent(t);
        testRead(design, sp);
        testWrite(design, sp);
    }

    @Test
    public void testWithSecondChild() {
        String design = "<vaadin-horizontal-split-panel><vaadin-button :second>Second slot</vaadin-button>"
                + "</vaadin-vertical-split-panel>";
        AbstractSplitPanel sp = new HorizontalSplitPanel();
        Button b = new Button("Second slot");
        b.setCaptionAsHtml(true);
        sp.setSecondComponent(b);
        testRead(design, sp);
        testWrite(design, sp);
    }

    @Test
    public void testEmpty() {
        String design = "<vaadin-horizontal-split-panel/>";
        AbstractSplitPanel sp = new HorizontalSplitPanel();
        testRead(design, sp);
        testWrite(design, sp);
    }
}
