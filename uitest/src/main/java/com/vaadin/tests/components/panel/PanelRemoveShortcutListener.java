/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.panel;

import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.event.ShortcutListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;

/**
 * Test for removing a shortcut listener from Panel.
 *
 * @author Vaadin Ltd
 */
public class PanelRemoveShortcutListener extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        final Panel panel = new Panel("No shortcut effects (press 'A')");
        panel.setWidth("200px");
        addComponent(panel);
        TextField textField = new TextField();
        panel.setContent(textField);
        ShortcutListener shortcut = createShortcutListener(panel);
        panel.addShortcutListener(shortcut);
        addButton("Remove shortcut", createClickListener(panel, shortcut));
    }

    private ShortcutListener createShortcutListener(final Panel panel) {
        return new ShortcutListener("A", KeyCode.A, null) {

            @Override
            public void handleAction(Object sender, Object target) {
                if ("A on".equals(panel.getCaption())) {
                    panel.setCaption("A off");
                } else {
                    panel.setCaption("A on");
                }
            }
        };
    }

    private ClickListener createClickListener(final Panel panel,
            final ShortcutListener shortcut) {
        return new Button.ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                panel.removeShortcutListener(shortcut);
                addComponent(new Label("shortcut removed"));
            }
        };
    }

    @Override
    protected Integer getTicketNumber() {
        return 16498;
    }

    @Override
    protected String getTestDescription() {
        return "Should be possible to remove shortcut listener from Panel";
    }

}
