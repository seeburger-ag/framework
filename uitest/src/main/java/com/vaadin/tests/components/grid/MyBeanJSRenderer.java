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
import com.vaadin.tests.components.grid.JavaScriptRenderers.MyBean;
import com.vaadin.ui.renderers.AbstractJavaScriptRenderer;

/**
 *
 * @since
 * @author Vaadin Ltd
 */
@JavaScript("myBeanJsRenderer.js")
public class MyBeanJSRenderer extends AbstractJavaScriptRenderer<MyBean> {

    public MyBeanJSRenderer() {
        super(MyBean.class, "");
    }

}
