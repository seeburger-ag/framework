/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.data.fieldgroup;

import org.junit.Test;

import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.ui.PopupDateField;

public class FieldGroupExceptionTest {

    @Test(expected = CommitException.class)
    public void testUnboundCommitException() throws CommitException {
        FieldGroup fieldGroup = new FieldGroup();
        PopupDateField dateField = new PopupDateField();
        fieldGroup.bind(dateField, "date");
        fieldGroup.commit();
    }

}
