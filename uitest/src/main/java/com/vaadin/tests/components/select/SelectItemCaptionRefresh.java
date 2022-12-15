/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.select;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Select;

public class SelectItemCaptionRefresh extends AbstractTestUI {

    final Object itemId = new Object();
    Select select;

    Button.ClickListener clickListener = new Button.ClickListener() {
        Integer i = Integer.valueOf(0);

        @Override
        public void buttonClick(final ClickEvent event) {
            select.setItemCaption(itemId, (i++).toString());
        }
    };

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.tests.components.AbstractTestUI#setup(com.vaadin.server.
     * VaadinRequest)
     */
    @Override
    protected void setup(VaadinRequest request) {
        select = new Select("Foo");

        select.addItem(itemId);
        select.setItemCaption(itemId, "start");

        addComponent(select);
        addComponent(new Button("Update item's caption", clickListener));
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.tests.components.AbstractTestUI#getTestDescription()
     */
    @Override
    protected String getTestDescription() {
        return "Selected option should be updated when item caption changes in the Select.";
    }

    /*
     * (non-Javadoc)
     *
     * @see com.vaadin.tests.components.AbstractTestUI#getTicketNumber()
     */
    @Override
    protected Integer getTicketNumber() {
        return 9250;
    }

}
