/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.draganddropwrapper;

import java.io.OutputStream;

import org.apache.commons.io.output.NullOutputStream;

import com.vaadin.annotations.Theme;
import com.vaadin.event.Transferable;
import com.vaadin.event.dd.DragAndDropEvent;
import com.vaadin.event.dd.DropHandler;
import com.vaadin.event.dd.acceptcriteria.AcceptAll;
import com.vaadin.event.dd.acceptcriteria.AcceptCriterion;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.StreamVariable;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.tests.components.AbstractTestUIWithLog;
import com.vaadin.ui.Button;
import com.vaadin.ui.DragAndDropWrapper;
import com.vaadin.ui.DragAndDropWrapper.WrapperTransferable;
import com.vaadin.ui.Html5File;
import com.vaadin.ui.Label;

@Theme("valo")
public class SingleUseDragAndDropUpload extends AbstractTestUIWithLog {

    @Override
    protected void setup(VaadinRequest request) {
        Label upload = new Label(FontAwesome.UPLOAD.getHtml(),
                ContentMode.HTML);
        upload.setSizeUndefined();
        upload.setStyleName("upload");
        getPage().getStyles().add(
                ".upload{ font-size: 36px; border: 1px solid black; padding:15px;}");

        final DragAndDropWrapper dnd = new DragAndDropWrapper(upload);
        dnd.setSizeUndefined();
        addComponent(dnd);
        dnd.setDropHandler(new DropHandler() {

            @Override
            public AcceptCriterion getAcceptCriterion() {
                return AcceptAll.get();
            }

            @Override
            public void drop(DragAndDropEvent event) {
                Transferable transferable = event.getTransferable();
                log("Drop occured");
                if (transferable instanceof WrapperTransferable) {
                    WrapperTransferable wTransferable = (WrapperTransferable) transferable;
                    Html5File[] files = wTransferable.getFiles();

                    if (files != null) {
                        for (Html5File file : files) {
                            log("Uploading file " + file.getFileName());
                            file.setStreamVariable(new StreamVariable() {

                                @Override
                                public void streamingStarted(
                                        StreamingStartEvent event) {
                                    log("Streaming started");
                                }

                                @Override
                                public void streamingFinished(
                                        StreamingEndEvent event) {
                                    log("Streaming finished");
                                    removeComponent(dnd);
                                    log("DragAndDropWrapper removed");
                                }

                                @Override
                                public void streamingFailed(
                                        StreamingErrorEvent event) {
                                }

                                @Override
                                public void onProgress(
                                        StreamingProgressEvent event) {
                                }

                                @Override
                                public boolean listenProgress() {
                                    return false;
                                }

                                @Override
                                public boolean isInterrupted() {
                                    return false;
                                }

                                @Override
                                public OutputStream getOutputStream() {
                                    return new NullOutputStream();
                                }
                            });
                        }
                    }
                }
            }
        });
        addComponent(new Button("Poll for changes"));
    }

    @Override
    protected String getTestDescription() {
        return "Drag a file to the upload icon and ensure there is no exceptions logged in the console";
    }
}
