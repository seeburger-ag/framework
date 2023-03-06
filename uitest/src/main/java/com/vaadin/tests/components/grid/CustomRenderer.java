/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid;

import com.vaadin.annotations.Widgetset;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.tests.widgetset.TestingWidgetSet;
import com.vaadin.tests.widgetset.client.SimpleTestBean;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.Label;

@Widgetset(TestingWidgetSet.NAME)
public class CustomRenderer extends AbstractTestUI {

    private static final Object INT_ARRAY_PROPERTY = "int array";
    private static final Object VOID_PROPERTY = "void";
    private static final Object BEAN_PROPERTY = "pojo";

    static final Object ITEM_ID = "itemId1";
    static final String DEBUG_LABEL_ID = "debuglabel";
    static final String INIT_DEBUG_LABEL_CAPTION = "Debug label placeholder";

    @Override
    protected void setup(VaadinRequest request) {
        IndexedContainer container = new IndexedContainer();
        container.addContainerProperty(INT_ARRAY_PROPERTY, int[].class,
                new int[] {});
        container.addContainerProperty(VOID_PROPERTY, Void.class, null);
        container.addContainerProperty(BEAN_PROPERTY, SimpleTestBean.class,
                null);

        Item item = container.addItem(ITEM_ID);

        @SuppressWarnings("unchecked")
        Property<int[]> propertyIntArray = item
                .getItemProperty(INT_ARRAY_PROPERTY);
        propertyIntArray.setValue(new int[] { 1, 1, 2, 3, 5, 8, 13 });

        @SuppressWarnings("unchecked")
        Property<SimpleTestBean> propertyPojo = item
                .getItemProperty(BEAN_PROPERTY);
        SimpleTestBean bean = new SimpleTestBean();
        bean.setValue(42);
        propertyPojo.setValue(bean);

        Label debugLabel = new Label(INIT_DEBUG_LABEL_CAPTION);
        debugLabel.setId(DEBUG_LABEL_ID);

        Grid grid = new Grid(container);

        grid.getColumn(INT_ARRAY_PROPERTY).setRenderer(new IntArrayRenderer());
        grid.getColumn(VOID_PROPERTY)
                .setRenderer(new RowAwareRenderer(debugLabel));
        grid.getColumn(BEAN_PROPERTY).setRenderer(new BeanRenderer());

        grid.setSelectionMode(SelectionMode.NONE);

        addComponent(grid);
        addComponent(debugLabel);
    }

    @Override
    protected String getTestDescription() {
        return "Verifies that renderers operating on other data than "
                + "just Strings also work ";
    }

    @Override
    protected Integer getTicketNumber() {
        return Integer.valueOf(13334);
    }

}
