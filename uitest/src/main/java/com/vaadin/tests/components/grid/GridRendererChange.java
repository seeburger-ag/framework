/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.renderers.ButtonRenderer;
import com.vaadin.ui.renderers.HtmlRenderer;
import com.vaadin.ui.renderers.TextRenderer;

public class GridRendererChange extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {

        final Grid grid = new Grid();
        grid.setColumns("num", "foo");
        grid.getColumn("num").setRenderer(new ButtonRenderer());

        for (int i = 0; i < 1000; i++) {
            grid.addRow(String.format("<b>line %d</b>", i), "" + i);
        }

        Button button = new Button("Set ButtonRenderer",
                new Button.ClickListener() {
                    @Override
                    public void buttonClick(ClickEvent event) {
                        grid.getColumn("num").setRenderer(new ButtonRenderer());
                    }
                });

        Button buttonHtml = new Button("Set HTMLRenderer",
                new Button.ClickListener() {
                    @Override
                    public void buttonClick(ClickEvent event) {
                        grid.getColumn("num").setRenderer(new HtmlRenderer());
                    }
                });

        Button buttonText = new Button("Set TextRenderer",
                new Button.ClickListener() {
                    @Override
                    public void buttonClick(ClickEvent event) {
                        grid.getColumn("num").setRenderer(new TextRenderer());
                    }
                });

        addComponent(new HorizontalLayout(button, buttonHtml, buttonText));
        addComponent(grid);
    }
}