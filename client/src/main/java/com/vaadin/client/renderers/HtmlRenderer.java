/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client.renderers;

import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.vaadin.client.widget.grid.RendererCellReference;

/**
 * Renders a string as HTML into a cell.
 * <p>
 * The html string is rendered as is without any escaping. It is up to the
 * developer to ensure that the html string honors the {@link SafeHtml}
 * contract. For more information see
 * {@link SafeHtmlUtils#fromSafeConstant(String)}.
 *
 * @since 7.4
 * @author Vaadin Ltd
 * @see SafeHtmlUtils#fromSafeConstant(String)
 */
public class HtmlRenderer implements Renderer<String> {

    @Override
    public void render(RendererCellReference cell, String htmlString) {
        cell.getElement()
                .setInnerSafeHtml(SafeHtmlUtils.fromSafeConstant(htmlString));
    }
}
