/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */

package com.vaadin.client.ui.textarea;

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.vaadin.client.WidgetUtil.CssSize;
import com.vaadin.client.ui.VTextArea;
import com.vaadin.client.ui.textfield.TextFieldConnector;
import com.vaadin.shared.ui.Connect;
import com.vaadin.shared.ui.textarea.TextAreaState;
import com.vaadin.ui.TextArea;

@Connect(TextArea.class)
public class TextAreaConnector extends TextFieldConnector {

    @Override
    public TextAreaState getState() {
        return (TextAreaState) super.getState();
    }

    @Override
    public VTextArea getWidget() {
        return (VTextArea) super.getWidget();
    }

    @Override
    protected void init() {
        super.init();

        getWidget().addMouseUpHandler(new ResizeMouseUpHandler());
    }

    /*
     * Workaround to handle the resize on the mouse up.
     */
    private class ResizeMouseUpHandler implements MouseUpHandler {

        @Override
        public void onMouseUp(MouseUpEvent event) {
            Element element = getWidget().getElement();

            updateSize(element.getStyle().getHeight(), getState().height,
                    "height");
            updateSize(element.getStyle().getWidth(), getState().width,
                    "width");
        }

        /*
         * Update the specified size on the server.
         */
        private void updateSize(String sizeText, String stateSizeText,
                String sizeType) {

            CssSize stateSize = CssSize.fromString(stateSizeText);
            CssSize newSize = CssSize.fromString(sizeText);

            if (stateSize == null && newSize == null) {
                return;

            } else if (newSize == null) {
                sizeText = "";

                // Else, if the current stateSize is null, just go ahead and set
                // the newSize, so no check on stateSize is needed.

            } else if (stateSize != null && stateSize.equals(newSize)) {
                return;
            }

            getConnection().updateVariable(getConnectorId(), sizeType, sizeText,
                    false);
        }

    }

}
