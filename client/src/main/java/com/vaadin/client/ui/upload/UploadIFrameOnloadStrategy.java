/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.upload;

import com.vaadin.client.ui.VUpload;

public class UploadIFrameOnloadStrategy {

    public native void hookEvents(com.google.gwt.dom.client.Element iframe,
            VUpload upload)
    /*-{
        iframe.onload = $entry(function() {
            upload.@com.vaadin.client.ui.VUpload::onSubmitComplete()();
        });
    }-*/;

    /**
     * @param iframe
     *            the iframe whose onLoad event is to be cleaned
     */
    public native void unHookEvents(com.google.gwt.dom.client.Element iframe)
    /*-{
        iframe.onload = null;
    }-*/;

}
