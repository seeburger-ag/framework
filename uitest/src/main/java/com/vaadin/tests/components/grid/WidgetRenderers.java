/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid;

import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.renderers.ButtonRenderer;
import com.vaadin.ui.renderers.ImageRenderer;
import com.vaadin.ui.renderers.ProgressBarRenderer;
import com.vaadin.ui.renderers.ClickableRenderer.RendererClickEvent;
import com.vaadin.ui.renderers.ClickableRenderer.RendererClickListener;

@SuppressWarnings("all")
public class WidgetRenderers extends AbstractTestUI {

    static final String PROPERTY_ID = "property id";

    @Override
    protected void setup(VaadinRequest request) {
        IndexedContainer container = new IndexedContainer();

        container.addContainerProperty(ProgressBarRenderer.class, Double.class,
                null);
        container.addContainerProperty(ButtonRenderer.class, String.class,
                null);
        container.addContainerProperty(ImageRenderer.class, Resource.class,
                null);
        container.addContainerProperty(PROPERTY_ID, String.class, null);

        final Item item = container.getItem(container.addItem());

        item.getItemProperty(ProgressBarRenderer.class).setValue(0.3);
        item.getItemProperty(ButtonRenderer.class).setValue("Click");
        item.getItemProperty(ImageRenderer.class)
                .setValue(new ThemeResource("window/img/close.png"));
        item.getItemProperty(PROPERTY_ID).setValue("Click");

        final Grid grid = new Grid(container);

        grid.setId("test-grid");
        grid.setSelectionMode(SelectionMode.NONE);

        grid.getColumn(ProgressBarRenderer.class)
                .setRenderer(new ProgressBarRenderer());

        grid.getColumn(ButtonRenderer.class)
                .setRenderer(new ButtonRenderer(new RendererClickListener() {
                    @Override
                    public void click(RendererClickEvent event) {
                        item.getItemProperty(ButtonRenderer.class)
                                .setValue("Clicked!");
                    }
                }));

        grid.getColumn(ImageRenderer.class)
                .setRenderer(new ImageRenderer(new RendererClickListener() {

                    @Override
                    public void click(RendererClickEvent event) {
                        item.getItemProperty(ImageRenderer.class).setValue(
                                new ThemeResource("window/img/maximize.png"));
                    }
                }));

        grid.getColumn(PROPERTY_ID)
                .setRenderer(new ButtonRenderer(new RendererClickListener() {
                    @Override
                    public void click(RendererClickEvent event) {
                        item.getItemProperty(PROPERTY_ID)
                                .setValue(event.getPropertyId());
                    }
                }));

        addComponent(grid);

        addComponent(new NativeButton("Change column order",
                new Button.ClickListener() {
                    @Override
                    public void buttonClick(ClickEvent event) {
                        grid.setColumnOrder(ImageRenderer.class,
                                ProgressBarRenderer.class,
                                ButtonRenderer.class);
                    }
                }));
    }

    @Override
    protected String getTestDescription() {
        return "Tests the functionality of widget-based renderers";
    }

    @Override
    protected Integer getTicketNumber() {
        return Integer.valueOf(13334);
    }
}
