/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.themes.valoutil;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Document;

public class BodyStyleName implements EntryPoint {

    @Override
    public void onModuleLoad() {
        Document.get().getBody().addClassName("valo");
    }

}
