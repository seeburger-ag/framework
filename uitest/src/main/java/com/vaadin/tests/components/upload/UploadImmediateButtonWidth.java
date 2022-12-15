/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.upload;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Upload;
import com.vaadin.ui.VerticalLayout;

// We're explicitly testing only immediate uploads here because non-immediate
// width issues still require planning before we can provide a fix.
public class UploadImmediateButtonWidth extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {

        // Let's use a separate layout without margins to make the
        // button widths not dependent on the selected theme.
        VerticalLayout layout = new VerticalLayout();
        layout.setWidth("500px");

        layout.addComponent(getImmediateUpload("upload1", "300px"));
        layout.addComponent(getImmediateUpload("upload2", "50%"));
        layout.addComponent(getImmediateUpload("upload3", ""));

        addComponent(layout);
    }

    private Upload getImmediateUpload(String id, String width) {
        Upload upload = new Upload();

        upload.setId(id);
        upload.setWidth(width);
        upload.setImmediate(true);

        return upload;
    }

    @Override
    protected String getTestDescription() {
        return "Width of the upload button should obey setWidth() when using immediate";
    }

    @Override
    protected Integer getTicketNumber() {
        return 14485;
    }

}
