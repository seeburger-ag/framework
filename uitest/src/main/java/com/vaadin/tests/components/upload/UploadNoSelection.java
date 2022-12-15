/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.upload;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUIWithLog;
import com.vaadin.ui.Upload;
import com.vaadin.ui.Upload.FailedEvent;
import com.vaadin.ui.Upload.FinishedEvent;
import com.vaadin.ui.Upload.Receiver;

public class UploadNoSelection extends AbstractTestUIWithLog
        implements Receiver {

    static final String LOG_ID_PREFIX = "Log_row_";
    static final String UPLOAD_ID = "u";

    static final String UPLOAD_FINISHED = "Upload Finished";
    static final String RECEIVING_UPLOAD = "Receiving upload";

    static final String FILE_LENGTH_PREFIX = "File length:";
    static final String FILE_NAME_PREFIX = "File name:";

    @Override
    protected Integer getTicketNumber() {
        return 9602;
    }

    @Override
    protected String getTestDescription() {
        return "Uploading an empty selection (no file) will trigger FinishedEvent with 0-length file size and empty filename.";
    }

    @Override
    protected void setup(VaadinRequest request) {
        Upload u = new Upload("Upload", this);
        u.setId(UPLOAD_ID);
        u.setSizeUndefined();

        addComponent(u);

        u.addFinishedListener(new Upload.FinishedListener() {
            @Override
            public void uploadFinished(FinishedEvent event) {
                log(UPLOAD_FINISHED);
                log(FILE_LENGTH_PREFIX + " " + event.getLength());
                log(FILE_NAME_PREFIX + " " + event.getFilename());
            }
        });
        u.addFailedListener(new Upload.FailedListener() {

            @Override
            public void uploadFailed(FailedEvent event) {
                log("Upload Failed");
                log(FILE_LENGTH_PREFIX + " " + event.getLength());
                log(FILE_NAME_PREFIX + " " + event.getFilename());
            }
        });
    }

    @Override
    public OutputStream receiveUpload(String filename, String MIMEType) {
        log(RECEIVING_UPLOAD);
        return new ByteArrayOutputStream();
    }

}
