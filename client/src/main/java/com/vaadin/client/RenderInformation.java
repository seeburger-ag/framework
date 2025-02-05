/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.client;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;

/**
 * Contains size information about a rendered container and its content area.
 *
 * @author Artur Signell
 *
 */
public class RenderInformation {

    private RenderSpace contentArea = new RenderSpace();
    private Size renderedSize = new Size(-1, -1);

    public void setContentAreaWidth(int w) {
        contentArea.setWidth(w);
    }

    public void setContentAreaHeight(int h) {
        contentArea.setHeight(h);
    }

    public RenderSpace getContentAreaSize() {
        return contentArea;

    }

    public Size getRenderedSize() {
        return renderedSize;
    }

    /**
     * Update the size of the widget.
     *
     * @param widget
     *
     * @return true if the size has changed since last update
     * @deprecated As of 7.2, call and override {@link #updateSize(Element)}
     *             instead
     */
    @Deprecated
    public boolean updateSize(com.google.gwt.user.client.Element element) {
        Size newSize = new Size(element.getOffsetWidth(),
                element.getOffsetHeight());
        if (newSize.equals(renderedSize)) {
            return false;
        } else {
            renderedSize = newSize;
            return true;
        }
    }

    /**
     * Update the size of the widget.
     *
     * @param widget
     *
     * @return true if the size has changed since last update
     *
     * @since 7.2
     */
    public boolean updateSize(Element element) {
        return updateSize(DOM.asOld(element));
    }

    @Override
    public String toString() {
        return "RenderInformation [contentArea=" + contentArea
                + ",renderedSize=" + renderedSize + "]";

    }

    public static class FloatSize {

        private float width, height;

        public FloatSize(float width, float height) {
            this.width = width;
            this.height = height;
        }

        public float getWidth() {
            return width;
        }

        public void setWidth(float width) {
            this.width = width;
        }

        public float getHeight() {
            return height;
        }

        public void setHeight(float height) {
            this.height = height;
        }

    }

    public static class Size {

        private int width, height;

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Size)) {
                return false;
            }
            Size other = (Size) obj;
            return other.width == width && other.height == height;
        }

        @Override
        public int hashCode() {
            return (width << 8) | height;
        }

        public Size() {
        }

        public Size(int width, int height) {
            this.height = height;
            this.width = width;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        @Override
        public String toString() {
            return "Size [width=" + width + ",height=" + height + "]";
        }
    }

}
