/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.ui.dd;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Wrapper for html5 File object.
 */
public class VHtml5File extends JavaScriptObject {

    protected VHtml5File() {
    }

    public native final String getName()
    /*-{
        return this.name;
     }-*/;

    public native final String getType()
    /*-{
        return this.type;
     }-*/;

    /*
     * Browser implementations support files >2GB dropped and report the value
     * as long. Due to JSNI limitations this value needs to be sent as double
     * and then cast back to a long value.
     * www.gwtproject.org/doc/latest/DevGuideCodingBasicsJSNI.html#important
     */
    public native final double getSize()
    /*-{
        return this.size ? this.size : 0;
    }-*/;

}
