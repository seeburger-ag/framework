/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.window;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

public class WindowCaption extends AbstractTestUI {

    private Window htmlWindow;
    private Window textWindow;

    @Override
    protected void setup(VaadinRequest request) {
        htmlWindow = new Window("", new Label("HTML caption"));
        htmlWindow.setId("htmlWindow");
        htmlWindow.setCaptionAsHtml(true);
        htmlWindow.setPositionX(300);
        htmlWindow.setPositionY(200);

        textWindow = new Window("", new Label("Text caption"));
        textWindow.setId("textWindow");
        textWindow.setCaptionAsHtml(false);
        textWindow.setPositionX(300);
        textWindow.setPositionY(400);

        addWindow(htmlWindow);
        addWindow(textWindow);

        Button red = new Button("Red", new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                setWindowCaption(
                        "<font style='color: red;'>This may or may not be red</font>");
            }
        });
        Button plainText = new Button("Plain text", new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                setWindowCaption("This is just text");
            }
        });
        Button nullCaption = new Button("Null", new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                setWindowCaption(null);
            }
        });
        Button empty = new Button("Empty", new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                setWindowCaption("");
            }
        });

        addComponents(red, plainText, nullCaption, empty);
        red.click();
    }

    private void setWindowCaption(String string) {
        htmlWindow.setCaption(string);
        textWindow.setCaption(string);
    }

}
