/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.upload;

import com.google.gwt.dom.client.Element;
import com.vaadin.client.ui.VUpload;

/**
 * IE does not have onload, detect onload via readystatechange
 *
 */
public class UploadIFrameOnloadStrategyIE extends UploadIFrameOnloadStrategy {
    @Override
    public native void hookEvents(Element iframe, VUpload upload)
    /*-{
      iframe.onreadystatechange = $entry(function() {
        if (iframe.readyState == 'complete') {
          upload.@com.vaadin.client.ui.VUpload::onSubmitComplete()();
        }
      });
    }-*/;

    @Override
    public native void unHookEvents(Element iframe)
    /*-{
      iframe.onreadystatechange = null;
    }-*/;

}
