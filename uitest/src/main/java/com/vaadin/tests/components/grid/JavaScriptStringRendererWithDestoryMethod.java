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

@JavaScript("JavaScriptStringRendererWithDestoryMethod.js")
public class JavaScriptStringRendererWithDestoryMethod
        extends AbstractJavaScriptRenderer<String> {

    protected JavaScriptStringRendererWithDestoryMethod() {
        super(String.class);
    }

}
