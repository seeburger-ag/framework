/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.validation;

import java.util.Set;

import com.vaadin.data.Validator;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.server.UserError;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.AbstractField;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.Field;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.RichTextArea;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.TwinColSelect;
import com.vaadin.ui.VerticalLayout;

public class FieldErrorIndication extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        HorizontalLayout hl = new HorizontalLayout();
        addComponent(hl);

        VerticalLayout vl = new VerticalLayout();
        hl.addComponent(vl);

        ComboBox comboBox = new ComboBox("ComboBox");
        comboBox.addItem("ok");
        comboBox.addItem("error");
        comboBox.addValidator(new StringLengthValidator("fail", 0, 2, false));
        comboBox.setValue("error");

        ListSelect listSelect = new ListSelect("ListSelect");
        listSelect.addItem("ok");
        listSelect.addItem("error");
        listSelect.addValidator(new StringLengthValidator("fail", 0, 2, false));
        listSelect.setValue("error");

        NativeSelect nativeSelect = new NativeSelect("NativeSelect");
        nativeSelect.addItem("ok");
        nativeSelect.addItem("error");
        nativeSelect
                .addValidator(new StringLengthValidator("fail", 0, 2, false));
        nativeSelect.setValue("error");
        TwinColSelect twinColSelect = new TwinColSelect("TwinColSelect");
        twinColSelect.addItem("ok");
        twinColSelect.addItem("error");
        twinColSelect.addValidator(new Validator() {

            @Override
            public void validate(Object value) throws InvalidValueException {
                if (value instanceof Set && ((Set) value).size() == 1
                        && ((Set) value).contains("ok")) {
                    return;
                }

                throw new InvalidValueException("fail");
            }

        });
        twinColSelect.setValue("error");

        vl.addComponents(comboBox, listSelect, nativeSelect, twinColSelect);

        Class<? extends AbstractField>[] textFields = new Class[] {
                TextField.class, TextArea.class, RichTextArea.class,
                PasswordField.class };
        vl = new VerticalLayout();
        hl.addComponent(vl);
        for (Class<? extends Field> fieldClass : textFields) {
            vl.addComponent(getField(fieldClass));
        }

    }

    /**
     * @since
     * @param fieldClass
     * @return
     */
    private Component getField(Class<? extends Field> fieldClass) {
        AbstractField f;
        try {
            f = (AbstractField) fieldClass.newInstance();
            f.setCaption(fieldClass.getSimpleName());
            f.setComponentError(new UserError("fail"));
            return f;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
