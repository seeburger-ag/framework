/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.tests;

import java.util.Locale;

import com.vaadin.server.ClassResource;
import com.vaadin.server.ErrorMessage;
import com.vaadin.server.UserError;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author Vaadin Ltd.
 */
public class TestDateField extends CustomComponent {

    VerticalLayout main = new VerticalLayout();

    DateField df;

    public TestDateField() {
        setCompositionRoot(main);
        createNewView();
    }

    public void createNewView() {
        main.removeAllComponents();
        main.addComponent(new Label("DateField"));

        df = new DateField();
        main.addComponent(df);

        final ErrorMessage errorMsg = new UserError("User error " + df);
        df.setCaption("DateField caption " + df);
        df.setDescription("DateField description " + df);
        df.setComponentError(errorMsg);
        df.setImmediate(true);
        // FIXME: bug #1138 this makes datefield to render with unknown
        // component (UIDL tree debug)
        df.addStyleName("thisShouldBeHarmless");

        // Another test: locale
        final DateField df1 = new DateField("US locale");
        main.addComponent(df1);
        df1.setLocale(new Locale("en", "US"));

        final DateField df2 = new DateField("DE locale");
        main.addComponent(df2);
        df2.setLocale(new Locale("de", "DE"));

        final DateField df3 = new DateField("RU locale");
        main.addComponent(df3);
        df3.setLocale(new Locale("ru", "RU"));

        final DateField df4 = new DateField("FI locale");
        main.addComponent(df4);
        df4.setLocale(new Locale("fi", "FI"));
    }

    @Override
    public void attach() {
        final ClassResource res = new ClassResource("m.gif");
        df.setIcon(res);
        super.attach();
    }

}
