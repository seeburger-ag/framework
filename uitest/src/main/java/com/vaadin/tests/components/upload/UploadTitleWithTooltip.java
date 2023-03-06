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

/**
 * Test UI for browser-dependent tootlip for Upload component.
 *
 * @author Vaadin Ltd
 */
public class UploadTitleWithTooltip extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        Upload upload = new Upload();
        upload.setDescription("tootlip");

        addComponent(upload);
    }

    @Override
    protected String getTestDescription() {
        return "Browser dependent title should not be visible for upload if Vaadin tooltip is used";
    }

    @Override
    protected Integer getTicketNumber() {
        return 14482;
    }

}
