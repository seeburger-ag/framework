/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.test.addonusinginitparamwidgetset;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import com.vaadin.addon.contextmenu.ContextMenu;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.test.widgetset.AbstractTestWidgetSetUI;
import com.vaadin.ui.AbstractComponent;

public class AddonUsingInitParamWidgetSetUI extends AbstractTestWidgetSetUI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        super.init(vaadinRequest);
        new ContextMenu((AbstractComponent) getContent(), true);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true, initParams = @WebInitParam(name = "widgetset", value = "com.vaadin.DefaultWidgetSet"))
    @VaadinServletConfiguration(ui = AddonUsingInitParamWidgetSetUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
