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
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;
import com.vaadin.ui.themes.ValoTheme;

public class SplitPanels extends VerticalLayout implements View {
    public SplitPanels() {
        setMargin(true);

        Label h1 = new Label("Split Panels");
        h1.addStyleName(ValoTheme.LABEL_H1);
        addComponent(h1);

        addComponent(new Label(
                "Outlines are just to show the areas of the SplitPanels. They are not part of the actual component style."));

        HorizontalLayout row = new HorizontalLayout();
        row.addStyleName(ValoTheme.LAYOUT_HORIZONTAL_WRAPPING);
        row.setSpacing(true);
        row.setMargin(new MarginInfo(true, false, false, false));
        addComponent(row);

        HorizontalSplitPanel sp = new HorizontalSplitPanel();
        sp.setCaption("Default style");
        sp.setWidth("400px");
        sp.setHeight(null);
        sp.setFirstComponent(getContent());
        sp.setSecondComponent(getContent());
        row.addComponent(sp);

        VerticalSplitPanel sp2 = new VerticalSplitPanel();
        sp2.setCaption("Default style");
        sp2.setWidth("300px");
        sp2.setHeight("200px");
        sp2.setFirstComponent(getContent());
        sp2.setSecondComponent(getContent());
        row.addComponent(sp2);

        sp = new HorizontalSplitPanel();
        sp.setCaption("Large style");
        sp.setWidth("300px");
        sp.setHeight("200px");
        sp.addStyleName(ValoTheme.SPLITPANEL_LARGE);
        sp.setFirstComponent(getContent());
        sp.setSecondComponent(getContent());
        row.addComponent(sp);

        sp2 = new VerticalSplitPanel();
        sp2.setCaption("Large style");
        sp2.setWidth("300px");
        sp2.setHeight("200px");
        sp2.addStyleName(ValoTheme.SPLITPANEL_LARGE);
        sp2.setFirstComponent(getContent());
        sp2.setSecondComponent(getContent());
        row.addComponent(sp2);
    }

    VerticalLayout getContent() {
        return new VerticalLayout() {
            {
                setMargin(true);
                addComponent(new Label(
                        "Fictum,  deserunt mollit anim laborum astutumque!"));
            }
        };
    }

    @Override
    public void enter(ViewChangeEvent event) {
        // TODO Auto-generated method stub

    }

}
