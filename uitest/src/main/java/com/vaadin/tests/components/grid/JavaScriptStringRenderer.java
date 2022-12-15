/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.components.grid;

import com.vaadin.annotations.JavaScript;
import com.vaadin.ui.renderers.AbstractJavaScriptRenderer;

@JavaScript("JavaScriptStringRenderer.js")
public class JavaScriptStringRenderer
        extends AbstractJavaScriptRenderer<String> {

    protected JavaScriptStringRenderer() {
        super(String.class);
    }

}
