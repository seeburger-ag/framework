/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.treetable;

import com.vaadin.data.Property;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.TreeTable;

import java.util.Set;

import static com.vaadin.server.Sizeable.Unit.PIXELS;

public class TreeTableMultiselect extends AbstractTestUI {

    protected final TreeTable tt = new TreeTable("Multiselectable treetable");
    protected Label label;

    @Override
    protected void setup(VaadinRequest request) {
        label = new Label("0");
        label.setCaption("Amount of selected items");
        label.setId("count");

        tt.setImmediate(true);
        tt.addContainerProperty("Foo", String.class, "");
        tt.setColumnWidth("Foo", 100);
        tt.addContainerProperty("Bar", String.class, "");
        tt.setColumnWidth("Bar", 100);
        tt.setHeight(400, PIXELS);
        Object item1 = tt.addItem(new Object[]{"Foo", "Bar"}, null);
        Object item2 = tt.addItem(new Object[]{"Foo2", "Bar2"}, null);
        Object item3 = tt.addItem(new Object[]{"Foo3", "Bar3"}, null);
        tt.setParent(item2, item1);
        tt.setParent(item3, item1);
        tt.setCollapsed(item1, false);
        tt.setSelectable(true);
        tt.setMultiSelect(true);
        tt.setMultiSelectTouchDetectionEnabled(false);
        tt.setWidth("400px");
        tt.setHeight("400px");
        tt.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                Property property = event.getProperty();
                Set set = (Set) property.getValue();
                label.setValue("" + set.size());
            }
        });

        addComponent(tt);
        addComponent(label);
    }

    @Override
    public String getDescription() {
        return "Allow disabling multi selection's touch screen detection for hybrid devices";
    }

    @Override
    protected Integer getTicketNumber() {
        return 11601;
    }

}
