/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.page;

import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;

@Title("bar")
public class PageTitle extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        String title = request.getParameter("title");
        if (title != null) {
            getPage().setTitle(title);
        }

    }

    @Override
    protected String getTestDescription() {
        return "Sets the title according to a given ?title parameter. By default the ApplicationServletRunner will set the title to the fully qualified class name";
    }

    @Override
    protected Integer getTicketNumber() {
        return 13430;
    }

}
