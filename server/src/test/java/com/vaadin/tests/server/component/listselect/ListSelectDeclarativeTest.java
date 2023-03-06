/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.server.component.listselect;

import org.junit.Test;

import com.vaadin.tests.design.DeclarativeTestBase;
import com.vaadin.ui.ListSelect;

public class ListSelectDeclarativeTest extends DeclarativeTestBase<ListSelect> {

    private ListSelect getWithOptionsExpected() {
        ListSelect ls = new ListSelect();
        ls.setRows(10);
        ls.addItem("Male");
        ls.addItem("Female");
        return ls;
    }

    private String getWithOptionsDesign() {
        return "<vaadin-list-select rows=10>\n"
                + "        <option>Male</option>\n"
                + "        <option>Female</option>\n"
                + "</vaadin-list-select>\n" + "";
    }

    @Test
    public void testReadWithOptions() {
        testRead(getWithOptionsDesign(), getWithOptionsExpected());
    }

    @Test
    public void testWriteWithOptions() {
        testWrite(stripOptionTags(getWithOptionsDesign()),
                getWithOptionsExpected());
    }

    private ListSelect getBasicExpected() {
        ListSelect ls = new ListSelect();
        ls.setCaption("Hello");
        return ls;
    }

    private String getBasicDesign() {
        return "<vaadin-list-select caption='Hello' />";
    }

    @Test
    public void testReadBasic() {
        testRead(getBasicDesign(), getBasicExpected());
    }

    @Test
    public void testWriteBasic() {
        testWrite(getBasicDesign(), getBasicExpected());
    }

}
