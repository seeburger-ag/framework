/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.button;

import java.util.LinkedHashMap;

import com.vaadin.tests.components.AbstractComponentTest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.themes.Reindeer;

public class Buttons2<T extends Button> extends AbstractComponentTest<T>
        implements ClickListener {

    private Command<T, Boolean> disableOnClickCommand = new Command<T, Boolean>() {

        @Override
        public void execute(T c, Boolean value, Object data) {
            c.setDisableOnClick(value);
        }
    };

    private Command<T, Boolean> clickListenerCommand = new Command<T, Boolean>() {

        @Override
        public void execute(T c, Boolean value, Object data) {
            if (value) {
                c.addListener((Button.ClickListener) Buttons2.this);
            } else {
                c.removeListener((Button.ClickListener) Buttons2.this);
            }

        }
    };

    @SuppressWarnings("unchecked")
    @Override
    protected Class<T> getTestClass() {
        return (Class<T>) Button.class;
    }

    @Override
    protected void createActions() {
        super.createActions();

        createBooleanAction("Disable on click", CATEGORY_FEATURES, false,
                disableOnClickCommand);
        addClickListener(CATEGORY_LISTENERS);
    }

    @Override
    protected void createComponentStyleNames(
            LinkedHashMap<String, String> options) {
        options.put("Reindeer default", Reindeer.BUTTON_DEFAULT);
        options.put("Reindeer small", Reindeer.BUTTON_SMALL);
        options.put("Reindeer link", Reindeer.BUTTON_LINK);
    }

    private void addClickListener(String category) {
        createBooleanAction("Click listener", category, false,
                clickListenerCommand);

    }

    @Override
    public void buttonClick(ClickEvent event) {
        log(event.getClass().getSimpleName());
    }
}
