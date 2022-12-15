/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.application;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUIWithLog;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

public class ConfirmBrowserTabClose extends AbstractTestUIWithLog {

    @Override
    protected void setup(VaadinRequest request) {
        // To test the behavior, do
        // 1. Open the test in the browser
        // 2. Close the browser tab/window
        // 3. Choose to stay on the page after all
        // 4. Click the button
        // There should be no error
        Button b = new Button("Say hello", new Button.ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                log("Hello");
            }
        });
        addComponent(b);
        getPage().getJavaScript()
                .eval("window.addEventListener('beforeunload', function (e) {"
                        + "var confirmationMessage = 'Please stay!';"
                        + "e.returnValue = confirmationMessage;"
                        + "return confirmationMessage;" + "});");
    }
}
