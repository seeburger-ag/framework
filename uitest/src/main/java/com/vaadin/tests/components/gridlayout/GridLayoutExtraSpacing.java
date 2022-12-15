/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.gridlayout;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.GridLayout;

public class GridLayoutExtraSpacing extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        getUI().getPage().getStyles().add(
                ".v-gridlayout {background: red;} .v-csslayout {background: white;}");

        final GridLayout gl = new GridLayout(4, 4);

        final CheckBox cb = new CheckBox("spacing");
        cb.addValueChangeListener(new ValueChangeListener() {

            @Override
            public void valueChange(ValueChangeEvent event) {
                gl.setSpacing(cb.getValue());
            }
        });
        cb.setValue(true);
        addComponent(cb);

        final CheckBox cb2 = new CheckBox("hide empty rows/columns");
        cb2.addValueChangeListener(new ValueChangeListener() {

            @Override
            public void valueChange(ValueChangeEvent event) {
                gl.setHideEmptyRowsAndColumns(cb2.getValue());
            }
        });
        addComponent(cb2);
        gl.setWidth("1000px");
        gl.setHeight("500px");

        CssLayout ta = new CssLayout();
        ta.setSizeFull();
        // Only on last row
        gl.addComponent(ta, 0, 3, 3, 3);

        gl.setRowExpandRatio(3, 1);
        addComponent(gl);

    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.tests.components.AbstractTestUI#getTestDescription()
     */
    @Override
    protected String getTestDescription() {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.tests.components.AbstractTestUI#getTicketNumber()
     */
    @Override
    protected Integer getTicketNumber() {
        // TODO Auto-generated method stub
        return null;
    }

}
