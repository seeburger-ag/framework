/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.abstractcomponent;

import com.vaadin.server.ErrorHandler;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUIWithLog;
import com.vaadin.ui.Button;

public class ResponseWritingErrorHandling extends AbstractTestUIWithLog {

    @Override
    protected void setup(VaadinRequest request) {
        ErrorHandler errorHandler = new ErrorHandler() {
            @Override
            public void error(com.vaadin.server.ErrorEvent event) {
                String message = event.getThrowable().getMessage();
                log(message);
            }
        };

        Button button = new Button("Throw in beforeClientResponse") {
            private boolean throwInBeforeClientResponse = false;
            {
                addClickListener(new ClickListener() {
                    @Override
                    public void buttonClick(ClickEvent event) {
                        throwInBeforeClientResponse = true;
                        // Make sure beforeClientResponse is called
                        markAsDirty();
                    }
                });
            }

            @Override
            public void beforeClientResponse(boolean initial) {
                if (throwInBeforeClientResponse) {
                    throwInBeforeClientResponse = false;
                    throw new RuntimeException("Button.beforeClientResponse");
                }
            }
        };
        button.setErrorHandler(errorHandler);

        addComponent(button);
    }

}
