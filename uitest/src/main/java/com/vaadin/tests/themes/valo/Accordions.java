/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.themes.valo;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class Accordions extends VerticalLayout implements View {
    public Accordions() {
        setMargin(true);

        Label h1 = new Label("Accordions");
        h1.addStyleName(ValoTheme.LABEL_H1);
        addComponent(h1);

        HorizontalLayout row = new HorizontalLayout();
        row.setSpacing(true);
        row.setWidth("100%");
        addComponent(row);

        row.addComponent(getAccordion("Normal"));

        Accordion ac = getAccordion("Borderless");
        ac.addStyleName(ValoTheme.ACCORDION_BORDERLESS);
        row.addComponent(ac);

    }

    Accordion getAccordion(String caption) {
        TestIcon testIcon = new TestIcon(0);
        Accordion ac = new Accordion();
        ac.setCaption(caption);
        ac.addTab(new VerticalLayout() {
            {
                setMargin(true);
                addComponent(new Label(
                        "Fabio vel iudice vincam, sunt in culpa qui officia. Ut enim ad minim veniam, quis nostrud exercitation."));
            }
        }, "First Caption", testIcon.get());
        ac.addTab(new VerticalLayout() {
            {
                setMargin(true);
                addComponent(new Label(
                        "Gallia est omnis divisa in partes tres, quarum."));
            }
        }, "Second Caption", testIcon.get());
        ac.addTab(new VerticalLayout() {
            {
                setMargin(true);
                addComponent(new Label(
                        "Nihil hic munitissimus habendi senatus locus, nihil horum? Sed haec quis possit intrepidus aestimare tellus."));
            }
        }, "Third Caption", testIcon.get());
        ac.addTab(new VerticalLayout() {
            {
                setMargin(true);
                addComponent(new Label(
                        "Inmensae subtilitatis, obscuris et malesuada fames. Quisque ut dolor gravida, placerat libero vel, euismod."));
            }
        }, "Custom Caption Style", testIcon.get()).setStyleName("color1");
        return ac;
    }

    @Override
    public void enter(ViewChangeEvent event) {
        // TODO Auto-generated method stub

    }

}
