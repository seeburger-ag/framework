/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.fieldgroup;

import java.text.DateFormat;
import java.util.Locale;

import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.IntegerRangeValidator;
import com.vaadin.event.SelectionEvent;
import com.vaadin.event.SelectionEvent.SelectionListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Grid;
import com.vaadin.ui.renderers.DateRenderer;

public class BasicCrudGridEditorRow extends AbstractBasicCrud {

    private Grid grid;

    @Override
    protected void setup(VaadinRequest request) {
        super.setup(request);
        formType.setVisible(false);
        grid = new Grid();

        grid.setContainerDataSource(container);

        grid.setColumnOrder((Object[]) columns);
        grid.removeColumn("salary");
        grid.addSelectionListener(new SelectionListener() {
            @Override
            public void select(SelectionEvent event) {
                Item item = grid.getContainerDataSource()
                        .getItem(grid.getSelectedRow());
                form.edit((BeanItem<ComplexPerson>) item);
            }
        });
        grid.setEditorEnabled(true);
        grid.setSizeFull();
        grid.getColumn("age").getEditorField().addValidator(
                new IntegerRangeValidator("Must be between 0 and 100", 0, 100));
        grid.getColumn("birthDate").setRenderer(new DateRenderer(
                DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.US)));
        addComponent(grid);
        getLayout().setExpandRatio(grid, 1);
    }

    @Override
    protected void deselectAll() {
        grid.select(null);
    }

}
