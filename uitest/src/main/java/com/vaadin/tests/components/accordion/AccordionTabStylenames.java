/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.accordion;

import com.vaadin.tests.components.TestBase;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet.Tab;

public class AccordionTabStylenames extends TestBase {

    @Override
    protected void setup() {
        Accordion acc = new Accordion();
        addComponent(acc);

        for (int tabIndex = 0; tabIndex < 5; tabIndex++) {
            Tab tab = acc.addTab(new Label("Tab " + tabIndex));
            tab.setCaption("Tab " + tabIndex);
            tab.setStyleName("tab" + tabIndex);
        }
    }

    @Override
    protected String getDescription() {
        return null;
    }

    @Override
    protected Integer getTicketNumber() {
        return 10605;
    }

}
