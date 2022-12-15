/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.popupview;

import com.vaadin.tests.components.TestBase;
import com.vaadin.ui.Component;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.PopupView.Content;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class PopupViewShouldCloseOnTabOut extends TestBase {

    @Override
    protected String getDescription() {
        return "The PopupView should close when the user moves focus away from it using the TAB key.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 5059;
    }

    @Override
    protected void setup() {
        PopupView pv = new PopupView(new Content() {

            @Override
            public String getMinimizedValueAsHTML() {
                return "<b>click me</b>";
            }

            @Override
            public Component getPopupComponent() {
                VerticalLayout vl = new VerticalLayout();
                TextField field1 = new TextField();
                field1.setValue("one");
                field1.focus();
                vl.addComponent(field1);
                TextField field2 = new TextField();
                field2.setValue("two");
                vl.addComponent(field2);
                vl.setWidth("600px");
                return vl;
            }
        });
        addComponent(pv);
        TextField main = new TextField();
        main.setValue("main");
        addComponent(main);
        TextField main2 = new TextField();
        main2.setValue("main2");
        addComponent(main2);
    }

}
