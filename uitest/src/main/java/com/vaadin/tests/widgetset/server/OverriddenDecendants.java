/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.widgetset.server;

import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.tests.widgetset.TestingWidgetSet;
import com.vaadin.ui.TextArea;

/**
 * UI for testing that @DelegateToWidget works on derived widget states.
 *
 * @since
 * @author Vaadin Ltd
 */
@Widgetset(TestingWidgetSet.NAME)
public class OverriddenDecendants extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {

        TextArea normalTextArea = new TextArea();
        normalTextArea.setRows(10);
        normalTextArea.setWordwrap(true);

        getLayout().addComponent(normalTextArea);

        // @DelegateToWidget will not work with overridden state in connector
        SuperTextArea superTextArea = new SuperTextArea();
        superTextArea.setRows(10);
        superTextArea.setWordwrap(true);

        getLayout().addComponent(superTextArea);

        // @DelegateToWidget will not work with overridden state in connector
        ExtraSuperTextArea extraSuperTextArea = new ExtraSuperTextArea();
        extraSuperTextArea.setRows(10);
        extraSuperTextArea.setWordwrap(true);

        getLayout().addComponent(extraSuperTextArea);
    }

    @Override
    protected String getTestDescription() {
        return "@DelegateToWidget does not work for widget descendants with overridden getState";
    }

    @Override
    protected Integer getTicketNumber() {
        return 14059;
    }

}
