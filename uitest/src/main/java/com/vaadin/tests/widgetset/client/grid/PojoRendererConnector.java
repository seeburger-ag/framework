/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests.widgetset.client.grid;

import com.vaadin.client.connectors.AbstractRendererConnector;
import com.vaadin.client.renderers.Renderer;
import com.vaadin.client.widget.grid.RendererCellReference;
import com.vaadin.shared.ui.Connect;
import com.vaadin.tests.widgetset.client.SimpleTestBean;

@Connect(com.vaadin.tests.components.grid.BeanRenderer.class)
public class PojoRendererConnector
        extends AbstractRendererConnector<SimpleTestBean> {

    public static class BeanRenderer implements Renderer<SimpleTestBean> {
        @Override
        public void render(RendererCellReference cell, SimpleTestBean bean) {
            cell.getElement().setInnerText(bean.toString());
        }
    }

    @Override
    public BeanRenderer getRenderer() {
        return (BeanRenderer) super.getRenderer();
    }
}
