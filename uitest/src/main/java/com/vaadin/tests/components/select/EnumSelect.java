/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.select;

import java.util.Locale;

import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.combobox.FilteringMode;
import com.vaadin.tests.components.AbstractTestUIWithLog;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Tree;

public class EnumSelect extends AbstractTestUIWithLog {

    public enum Constant {
        SOME_VALUE, SOME_OTHER_VALUE, FOO, BAR;
    }

    @Override
    protected void setup(VaadinRequest request) {

        setLocale(new Locale("fi", "FI"));
        ComboBox cb = new ComboBox();
        cb.setFilteringMode(FilteringMode.CONTAINS);
        for (Constant c : Constant.values()) {
            cb.addItem(c);
        }
        addComponent(cb);

        NativeSelect ns = new NativeSelect();
        for (Constant c : Constant.values()) {
            ns.addItem(c);
        }
        addComponent(ns);

        Tree t = new Tree();
        t.addItem(Constant.SOME_OTHER_VALUE);
        t.addItem(2500.12);
        t.setParent(2500.12, Constant.SOME_OTHER_VALUE);

        addComponent(t);

    }

    @Override
    protected String getTestDescription() {
        return "Test formatting captions with enum converters in selection components";
    }

    @Override
    protected Integer getTicketNumber() {
        return 11433;
    }

}
