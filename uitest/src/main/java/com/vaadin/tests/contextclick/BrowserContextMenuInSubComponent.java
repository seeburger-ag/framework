/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.contextclick;

import com.vaadin.annotations.Widgetset;
import com.vaadin.event.ContextClickEvent;
import com.vaadin.event.ContextClickEvent.ContextClickListener;
import com.vaadin.server.AbstractExtension;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.tests.widgetset.TestingWidgetSet;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;

@Widgetset(TestingWidgetSet.NAME)
public class BrowserContextMenuInSubComponent extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        Panel panel = new Panel();

        VerticalLayout layout = new VerticalLayout();
        final TextArea textArea = new TextArea();
        // Make TextArea show regular context menu instead of firing the
        // server-side event.
        BrowserContextMenuExtension.extend(textArea);
        final Button button = new Button("Submit", new Button.ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                Notification.show(textArea.getValue());
            }
        });

        layout.addComponent(textArea);
        layout.addComponent(button);

        panel.setContent(layout);

        panel.addContextClickListener(new ContextClickListener() {

            @Override
            public void contextClick(ContextClickEvent event) {
                button.click();
            }
        });

        addComponent(panel);
    }

    /**
     * A simple extension for making extended component stop propagation of the
     * context click events, so the browser will handle the context click and
     * show its own context menu.
     */
    public static class BrowserContextMenuExtension extends AbstractExtension {
        private BrowserContextMenuExtension(AbstractComponent c) {
            super(c);
        }

        public static BrowserContextMenuExtension extend(AbstractComponent c) {
            return new BrowserContextMenuExtension(c);
        }
    }

}
