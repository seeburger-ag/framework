/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.declarative;

import com.vaadin.annotations.DesignRoot;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.declarative.Design;

@DesignRoot
public class PotusCrud extends VerticalLayout {

    public Table potusList;
    public PotusForm potusForm;
    public Button addNew;

    private FieldGroup fg;

    private BeanItemContainer<Potus> potusContainer = new BeanItemContainer<Potus>(
            Potus.class);

    public PotusCrud() {
        Design.read(this);
        init();
    }

    private void init() {
        initTable();
        initForm();
        addNew.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                doAdd();
            }
        });
    }

    private void initTable() {
        potusList.setContainerDataSource(potusContainer);
        potusList.addValueChangeListener(new ValueChangeListener() {
            @Override
            public void valueChange(ValueChangeEvent event) {
                doEdit();
            }
        });
    }

    private void initForm() {
        potusForm.save.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                doSave();
            }

        });
        potusForm.delete.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                doDelete();
            }
        });
        potusForm.revert.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                doRevert();
            }
        });
        fg = new FieldGroup();
    }

    protected void doRevert() {
        fg.discard();
    }

    protected void doDelete() {
        potusContainer.removeItem(potusList.getValue());
        fg.setItemDataSource(null);
    }

    protected void doSave() {
        try {
            fg.commit();
        } catch (CommitException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    protected void doAdd() {
        potusContainer.addBean(new Potus());
    }

    protected void doEdit() {
        if (potusList.getValue() != null) {
            fg.setItemDataSource(potusList.getItem(potusList.getValue()));
            fg.bindMemberFields(potusForm);
        } else {
            fg.setItemDataSource(null);
        }
    }

}
